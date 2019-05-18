package biblioteca.bll.interfaces;

import java.util.*;

import biblioteca.dal.entidade.Editora;
import biblioteca.bll.util.Mensagem;

public interface IEditoraEJB {
	public Mensagem salvar(Editora editora);
	public Mensagem excluir(Short idEditora);
	public List<Editora> listar();
}
