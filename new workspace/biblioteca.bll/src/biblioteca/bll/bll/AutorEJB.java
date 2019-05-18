package biblioteca.bll.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import biblioteca.bll.util.Mensagem;
import biblioteca.bll.util.TipoMensagem;
import biblioteca.bll.interfaces.IAutorEJB;
import biblioteca.dal.interfaces.IAutorDAO;
import biblioteca.dal.entidade.Autor;

@Stateless
public class AutorEJB implements IAutorEJB{
	
	@Inject
	private IAutorDAO autorDAO;
	
	@Override
	public Mensagem salvar(Autor autor) {
		try {
			
			autorDAO.insertOrUpdate(autor);
			return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
			
		}  catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);		
		}
	}
	
	public Mensagem excluir(Short idAutor) {
		try {
			Autor autor = autorDAO.findById(idAutor);
			
			if(autor == null) {
				throw new Exception("Autor inexistente.");
			}
			
			autorDAO.delete(autor);
			return new Mensagem("Autor excluído.", TipoMensagem.sucesso);
		} catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);
		}
	}
	
	public List<Autor> listar(){
		return autorDAO.findAll();
	}
	
}
