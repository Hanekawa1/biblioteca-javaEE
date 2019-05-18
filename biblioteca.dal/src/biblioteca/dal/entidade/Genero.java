package biblioteca.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idGenero;
	
	@NotNull(message = "Informe o gênero")
	private String descricaoGenero;

	//Getters & Setters
	
	public Short getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Short idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescricaoGenero() {
		return descricaoGenero;
	}

	public void setDescricaoGenero(String descricaoGenero) {
		this.descricaoGenero = descricaoGenero;
	}

	//HashCode & Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGenero == null) ? 0 : idGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		return true;
	}
	
}
