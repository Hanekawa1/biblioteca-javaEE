package biblioteca.dal.dao;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.dao.interfaces.ITipoObraDAO;
import biblioteca.dal.entidade.TipoObra;
import biblioteca.dal.generics.JPAGenericDAO;

@RequestScoped
public class TipoObraDAO 	
	extends JPAGenericDAO<TipoObra, Short>
	implements ITipoObraDAO{

}
