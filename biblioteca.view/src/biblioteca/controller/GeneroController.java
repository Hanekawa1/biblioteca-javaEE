package biblioteca.controller;

import java.util.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import biblioteca.bll.interfaces.IGeneroEJB;
import biblioteca.bll.util.*;
import biblioteca.dal.entidade.Genero;

@Named
@RequestScoped
public class GeneroController {
	
	private Genero genero;
	
	@EJB
	private IGeneroEJB generoEJB;
	
	@Inject
	private FacesContext context;
	
	public GeneroController() {
		this.genero = new Genero();
	}
	
	public void salvar() {
		
		Mensagem msg = generoEJB.salvar(genero);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.genero = new Genero();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
	}
	
	public List<Genero> todos(){
		return generoEJB.listar();
	}
	
	public void editar(Genero genero) {
		this.genero = genero;
	}
	
	public void excluir(Short idAutor) {
		Mensagem msg = generoEJB.excluir(idAutor);
		
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
	
	public Genero getGenero() {
		return genero;
	}

	public void setAutor(Genero genero) {
		this.genero = genero;
	}
}
