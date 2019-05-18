package biblioteca.dal.dao;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.entidade.TipoObra;
import biblioteca.dal.generics.JPAGenericDAO;
import biblioteca.dal.interfaces.ITipoObraDAO;

@RequestScoped
public class TipoObraDAO 	
	extends JPAGenericDAO<TipoObra, Short>
	implements ITipoObraDAO{

}
