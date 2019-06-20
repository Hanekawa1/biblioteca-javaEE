package biblioteca.dal.dao;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.dao.interfaces.IGeneroDAO;
import biblioteca.dal.entidade.Genero;
import biblioteca.dal.generics.JPAGenericDAO;

@RequestScoped
public class GeneroDAO 	
	extends JPAGenericDAO<Genero, Short>
	implements IGeneroDAO{

}
