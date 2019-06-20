package biblioteca.bll.interfaces;

import biblioteca.dal.entidade.*;
import biblioteca.bll.util.*;

public interface IUsuarioEJB {
	
	public Mensagem autenticar(Usuario usuario);
}
