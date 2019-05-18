package biblioteca.bll.interfaces;

import java.util.*;

import biblioteca.dal.entidade.Genero;
import biblioteca.bll.util.Mensagem;

public interface IGeneroEJB {
	public Mensagem salvar(Genero genero);
	public Mensagem excluir(Short idGenero);
	public List<Genero> listar();
}
