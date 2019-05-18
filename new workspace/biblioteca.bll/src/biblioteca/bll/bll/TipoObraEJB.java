package biblioteca.bll.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import biblioteca.bll.util.Mensagem;
import biblioteca.bll.util.TipoMensagem;
import biblioteca.bll.interfaces.ITipoObraEJB;
import biblioteca.dal.interfaces.ITipoObraDAO;
import biblioteca.dal.entidade.TipoObra;


@Stateless
public class TipoObraEJB implements ITipoObraEJB {
	
	@Inject
	private ITipoObraDAO tipoObraDAO;
	
	
	@Override
	public Mensagem salvar(TipoObra tipoObra) {
		try {
			
			tipoObraDAO.insertOrUpdate(tipoObra);
			return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
			
		}  catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);		
		}
	}
	
	@Override
	public Mensagem excluir(Short idTipoObra) {
		try {
			TipoObra tipoObra = tipoObraDAO.findById(idTipoObra);
			
			if(tipoObra == null) {
				throw new Exception("Esse tipo de Obra já foi excluido.");
			}
			
			tipoObraDAO.delete(tipoObra);
			return new Mensagem("Tipo de Obra excluído.", TipoMensagem.sucesso);
			
		} catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);
		}
	}
	
	@Override
	public List<TipoObra> listar(){
		return tipoObraDAO.findAll();
	}
	
}
