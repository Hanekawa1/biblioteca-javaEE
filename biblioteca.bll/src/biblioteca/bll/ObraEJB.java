package biblioteca.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.*;

import biblioteca.bll.util.Mensagem;
import biblioteca.bll.util.TipoMensagem;
import biblioteca.bll.interfaces.IObraEJB;
import biblioteca.dal.dao.interfaces.IObraDAO;
import biblioteca.dal.entidade.Obra;

@Stateless
public class ObraEJB implements IObraEJB {
	
	@Inject
	private IObraDAO obraDAO;
	
	
	@Override
	public Mensagem salvar(Obra Obra) {
		try {
			
			obraDAO.insertOrUpdate(Obra);
			return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
			
		}  catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);		
		}
	}
	
	@Override
	public Mensagem excluir(Integer idObra) {
		try {
			Obra obra = obraDAO.findById(idObra);
			
			if(obra == null) {
				throw new Exception("Essa Obra já foi excluida.");
			}
			
			obraDAO.delete(obra);
			return new Mensagem("Obra excluída.", TipoMensagem.sucesso);
			
		} catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);
		}
	}
	
	@Override
	public List<Obra> listar(){
		return obraDAO.findAll();
	}
	
}
