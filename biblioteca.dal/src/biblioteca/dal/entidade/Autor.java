package biblioteca.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idAutor;
	
	@NotNull(message = "Informe o código do Autor")
	private String codAutor;
	
	@NotNull(message = "Informe o Pseudonimo do Autor")
	private String pseudonimo;

	//Getters & Setters
	
	public Short getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Short idAutor) {
		this.idAutor = idAutor;
	}

	public String getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(String codAutor) {
		this.codAutor = codAutor;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	//HashCode & Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutor == null) ? 0 : idAutor.hashCode());
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
		Autor other = (Autor) obj;
		if (idAutor == null) {
			if (other.idAutor != null)
				return false;
		} else if (!idAutor.equals(other.idAutor))
			return false;
		return true;
	}
	
}
