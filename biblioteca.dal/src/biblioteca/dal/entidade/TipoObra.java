package biblioteca.dal.entidade;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TipoObra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idTipoObra;
	
	@NotNull(message = "Informe o Tipo da Obra")
	private String descricaoTipo;
	
	@OneToMany(mappedBy = "tipoObra")
	private List<Obra> obras;
	
	//Getters & Setters

	public Short getIdTipoObra() {
		return idTipoObra;
	}

	public void setIdTipoObra(Short idTipoObra) {
		this.idTipoObra = idTipoObra;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

	//HashCode & Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoObra == null) ? 0 : idTipoObra.hashCode());
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
		TipoObra other = (TipoObra) obj;
		if (idTipoObra == null) {
			if (other.idTipoObra != null)
				return false;
		} else if (!idTipoObra.equals(other.idTipoObra))
			return false;
		return true;
	}
		
}
