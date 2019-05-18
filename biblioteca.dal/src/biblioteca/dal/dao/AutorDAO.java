package biblioteca.dal.dao;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.entidade.Autor;
import biblioteca.dal.generics.JPAGenericDAO;
import biblioteca.dal.interfaces.IAutorDAO;

@RequestScoped
public class AutorDAO 
	extends JPAGenericDAO<Autor, Short>
	implements IAutorDAO{

}
