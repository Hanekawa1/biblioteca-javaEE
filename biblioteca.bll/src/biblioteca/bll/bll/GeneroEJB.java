package biblioteca.bll.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import biblioteca.bll.util.Mensagem;
import biblioteca.bll.util.TipoMensagem;
import biblioteca.bll.interfaces.IGeneroEJB;
import biblioteca.dal.interfaces.IGeneroDAO;
import biblioteca.dal.entidade.Genero;

@Stateless
public class GeneroEJB implements IGeneroEJB{

	@Inject
	private IGeneroDAO generoDAO;
	
	@Override
	public Mensagem salvar(Genero genero) {
		try {
			
			generoDAO.insertOrUpdate(genero);
			return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
			
		}  catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);		
		}
	}
	
	@Override
	public Mensagem excluir(Short idGenero) {
		try {
			Genero genero = generoDAO.findById(idGenero);
			
			if(genero == null) {
				throw new Exception("Autor inexistente.");
			}
			
			generoDAO.delete(genero);
			return new Mensagem("Genero excluído.", TipoMensagem.sucesso);
		} catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);
		}
	}
	
	@Override
	public List<Genero> listar(){
		return generoDAO.findAll();
	}
	
}
