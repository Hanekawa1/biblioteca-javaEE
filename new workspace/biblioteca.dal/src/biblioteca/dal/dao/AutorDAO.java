package biblioteca.dal.dao;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.dao.interfaces.IAutorDAO;
import biblioteca.dal.entidade.Autor;
import biblioteca.dal.generics.JPAGenericDAO;

@RequestScoped
public class AutorDAO 
	extends JPAGenericDAO<Autor, Short>
	implements IAutorDAO{

}
