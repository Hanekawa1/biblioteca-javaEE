package biblioteca.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Editora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idEditora;
	
	@NotNull(message = "Informe o nome da Editora")
	private String nomeEditora;
	
	@OneToMany(mappedBy = "editora")
	private List<Obra> obras;
	
	//Getters & Setters
	
	public Short getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Short idEditora) {
		this.idEditora = idEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	
	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}
	
	//HashCode & Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEditora == null) ? 0 : idEditora.hashCode());
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
		Editora other = (Editora) obj;
		if (idEditora == null) {
			if (other.idEditora != null)
				return false;
		} else if (!idEditora.equals(other.idEditora))
			return false;
		return true;
	}

}
