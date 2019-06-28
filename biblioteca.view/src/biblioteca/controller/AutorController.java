package biblioteca.controller;

import java.util.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import biblioteca.bll.interfaces.IAutorEJB;
import biblioteca.bll.util.*;
import biblioteca.dal.entidade.Autor;

@Named
@RequestScoped
public class AutorController {

	private Autor autor;
	
	@EJB
	private IAutorEJB autorEJB;
	
	@Inject
	private FacesContext context;
	
	public AutorController() {
		this.autor = new Autor();
	}
	
	public void salvar() {
		
		Mensagem msg = autorEJB.salvar(autor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.autor = new Autor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
	}
	
	public List<Autor> todos(){
		return autorEJB.listar();
	}
	
	public void editar(Autor autor) {
		this.autor = autor;
	}
	
	public void excluir(Short idAutor) {
		Mensagem msg = autorEJB.excluir(idAutor);
		
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
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
