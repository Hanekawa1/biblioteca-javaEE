package biblioteca.dal.dao;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.entidade.Genero;
import biblioteca.dal.generics.JPAGenericDAO;
import biblioteca.dal.interfaces.IGeneroDAO;

@RequestScoped
public class GeneroDAO 	
	extends JPAGenericDAO<Genero, Short>
	implements IGeneroDAO{

}
