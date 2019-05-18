package biblioteca.bll.interfaces;

import java.util.*;

import biblioteca.dal.entidade.TipoObra;
import biblioteca.bll.util.Mensagem;

public interface ITipoObraEJB {
	public Mensagem salvar(TipoObra tipoObra);
	public Mensagem excluir(Short idTipoObra);
	public List<TipoObra> listar();
}
