package biblioteca.test;

import java.util.*;

import javax.ejb.embeddable.*;
import javax.naming.*;

import biblioteca.dal.entidade.*;
import biblioteca.dal.interfaces.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		p.put("locadoraDB", "new://Resource?type=DataSource");
		p.put("locadoraDB.JdbcDriver", "com.mysql.jdbc.Driver");
		p.put("locadoraDB.JdbcUrl","jdbc:mysql://localhost:3306/biblioteca");
		p.put("locadoraDB.userName","root");
		p.put("locadoraDB.password","");
		
		Context context = EJBContainer.createEJBContainer(p).getContext();
		
		ITipoObraDAO tipoObraDAO = (ITipoObraDAO) context.lookup("java:global/biblioteca.dal/TipoObraDAO");
		
		
		//TipoObra tipoObra = new TipoObra();
		//tipoObra.setDescricaoTipo("Livro");
		
		//tipoObraDAO.insert(tipoObra);
		
		List<TipoObra> tipoObras = tipoObraDAO.findAll();
		
		for(TipoObra tipoObra : tipoObras) {
			System.out.println(tipoObra.getDescricaoTipo());
		}
		
	}
}
