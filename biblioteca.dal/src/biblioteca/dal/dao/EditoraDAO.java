package biblioteca.dal.dao;

import biblioteca.dal.interfaces.IEditoraDAO;

import javax.enterprise.context.RequestScoped;

import biblioteca.dal.entidade.Editora;
import biblioteca.dal.generics.JPAGenericDAO;

@RequestScoped
public class EditoraDAO 
	extends JPAGenericDAO<Editora, Short>
	implements IEditoraDAO{

}
