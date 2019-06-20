package biblioteca.dal.dao.interfaces;

import biblioteca.dal.entidade.*;
import biblioteca.dal.generics.IGenericDAO;

public interface IUsuarioDAO extends IGenericDAO<Usuario, Integer>{
	public Usuario porLoginSenha(String login, String senha);
}
