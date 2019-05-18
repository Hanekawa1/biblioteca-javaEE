package biblioteca.bll.interfaces;

import java.util.*;

import biblioteca.dal.entidade.Obra;
import biblioteca.bll.util.Mensagem;

public interface IObraEJB {
	public Mensagem salvar(Obra Obra);
	public Mensagem excluir(Integer idObra);
	public List<Obra> listar();
}
