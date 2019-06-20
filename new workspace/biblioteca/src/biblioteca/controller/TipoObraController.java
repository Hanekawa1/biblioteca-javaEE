package biblioteca.controller;

import java.util.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import biblioteca.bll.interfaces.ITipoObraEJB;
import biblioteca.bll.util.*;
import biblioteca.dal.entidade.TipoObra;

@Named
@RequestScoped
public class TipoObraController {

	private TipoObra tipoObra;
	
	@EJB
	private ITipoObraEJB tipoObraEJB;
	
	@Inject
	private FacesContext context;
	
	public TipoObraController() {
		this.tipoObra = new TipoObra();
	}
	
	public void salvar() {
		
		Mensagem msg = tipoObraEJB.salvar(tipoObra);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.tipoObra = new TipoObra();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
	}
	
	public List<TipoObra> todos(){
		return tipoObraEJB.listar();
	}
	
	public void editar(TipoObra tipoObra) {
		this.tipoObra = tipoObra;
	}
	
	public void excluir(Short idAutor) {
		Mensagem msg = tipoObraEJB.excluir(idAutor);
		
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
	
	public TipoObra getTipoObra() {
		return tipoObra;
	}

	public void setAutor(TipoObra tipoObra) {
		this.tipoObra = tipoObra;
	}
}
