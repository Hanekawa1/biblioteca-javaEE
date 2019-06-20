package biblioteca.controller;

import java.util.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import biblioteca.bll.interfaces.IEditoraEJB;
import biblioteca.bll.util.*;
import biblioteca.dal.entidade.Editora;

@Named
@RequestScoped
public class EditoraController {

	private Editora editora;
	
	@EJB
	private IEditoraEJB editoraEJB;
	
	@Inject
	private FacesContext context;
	
	public EditoraController() {
		this.editora = new Editora();
	}
	
	public void salvar() {
		
		Mensagem msg = editoraEJB.salvar(editora);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.editora = new Editora();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
	}
	
	public List<Editora> todos(){
		return editoraEJB.listar();
	}
	
	public void editar(Editora editora) {
		this.editora = editora;
	}
	
	public void excluir(Short idAutor) {
		Mensagem msg = editoraEJB.excluir(idAutor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
	}
	
	public Editora getAutor() {
		return editora;
	}

	public void setAutor(Editora editora) {
		this.editora = editora;
	}
}
