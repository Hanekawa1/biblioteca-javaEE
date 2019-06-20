package biblioteca.bll.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import biblioteca.bll.util.Mensagem;
import biblioteca.bll.util.TipoMensagem;
import biblioteca.bll.interfaces.IEditoraEJB;
import biblioteca.dal.dao.interfaces.*;
import biblioteca.dal.entidade.Editora;

@Stateless
public class EditoraEJB implements IEditoraEJB{
	
	@Inject
	private IEditoraDAO editoraDAO;
	
	@Override
	public Mensagem salvar(Editora editora) {
		try {
			
			editoraDAO.insertOrUpdate(editora);
			return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
			
		} catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);		
		}
	}
	
	@Override
	public Mensagem excluir(Short idEditora) {
		try {
			Editora editora = editoraDAO.findById(idEditora);
			
			if(editora == null) {
				throw new Exception("Editora inexistente.");
			}
			
			editoraDAO.delete(editora);
			return new Mensagem("Editora excluída.", TipoMensagem.sucesso);
			
		} catch(Exception ex) {
			return new Mensagem("Erro inesperado: " + ex.getMessage(), TipoMensagem.erro);
		}
	}
	
	@Override
	public List<Editora> listar(){
		return editoraDAO.findAll();
	}
	
}
