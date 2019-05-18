package biblioteca.dal.entidade;

import javax.persistence.*;

@Embeddable
public class GeneroObraPK {

	private Short idGenero;
	private Integer idObra;
	
	public Short getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Short idGenero) {
		this.idGenero = idGenero;
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
		result = prime * result + ((idGenero == null) ? 0 : idGenero.hashCode());
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
		GeneroObraPK other = (GeneroObraPK) obj;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		if (idObra == null) {
			if (other.idObra != null)
				return false;
		} else if (!idObra.equals(other.idObra))
			return false;
		return true;
	}
	
	
	
}
