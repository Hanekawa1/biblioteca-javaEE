package biblioteca.dal.dao;

import biblioteca.dal.interfaces.IObraDAO;
import biblioteca.dal.entidade.Obra;
import biblioteca.dal.generics.JPAGenericDAO;

public class ObraDAO 
	extends JPAGenericDAO<Obra, Integer>
	implements IObraDAO{

}