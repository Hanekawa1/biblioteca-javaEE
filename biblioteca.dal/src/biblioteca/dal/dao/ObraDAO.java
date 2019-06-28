package biblioteca.dal.dao;

import biblioteca.dal.dao.interfaces.IObraDAO;
import biblioteca.dal.entidade.Obra;
import biblioteca.dal.generics.JPAGenericDAO;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ObraDAO 
	extends JPAGenericDAO<Obra, Integer>
	implements IObraDAO{

}
