package biblioteca.bll.interfaces;

import java.util.*;

import biblioteca.dal.entidade.Autor;
import biblioteca.bll.util.Mensagem;

public interface IAutorEJB {

	public Mensagem salvar(Autor autor);
	public Mensagem excluir(Short idAutor);
	public List<Autor> listar();
	
}
