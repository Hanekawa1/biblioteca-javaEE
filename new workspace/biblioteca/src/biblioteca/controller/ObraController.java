package biblioteca.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import biblioteca.bll.interfaces.IObraEJB;
import biblioteca.bll.util.*;
import biblioteca.dal.entidade.*;

@Named
@RequestScoped
public class ObraController {
	
	private Obra obra;
	
	@EJB
	private IObraEJB obraEJB;
	
	@Inject
	private FacesContext context;
	
	public ObraController() {
		this.obra = new Obra();
	}
	
public void salvar() {
		
		Mensagem msg = obraEJB.salvar(obra);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.obra = new Obra();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Obra> todos(){
		return obraEJB.listar();
	}
	
	public void editar(Obra obra) {
		this.obra = obra;
	}
	
	
	public void excluir(Integer idAutomovel) {
		
		Mensagem msg = obraEJB.excluir(idAutomovel);
		
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

	public Obra getObra() {
		return obra;
	}

	public void setAutomovel(Obra obra) {
		this.obra = obra;
	}

}
