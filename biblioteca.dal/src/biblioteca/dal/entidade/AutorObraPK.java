package biblioteca.dal.entidade;

import javax.persistence.*;

@Embeddable
public class AutorObraPK {

	private Short idAutor;
	private Integer idObra;
	
	public Short getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Short idAutor) {
		this.idAutor = idAutor;
	}
	public Integer getIdObra() {
		return idObra;
	}
	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutor == null) ? 0 : idAutor.hashCode());
		result = prime * result + ((idObra == null) ? 0 : idObra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorObraPK other = (AutorObraPK) obj;
		if (idAutor == null) {
			if (other.idAutor != null)
				return false;
		} else if (!idAutor.equals(other.idAutor))
			return false;
		if (idObra == null) {
			if (other.idObra != null)
				return false;
		} else if (!idObra.equals(other.idObra))
			return false;
		return true;
	}
	
	
	
}
