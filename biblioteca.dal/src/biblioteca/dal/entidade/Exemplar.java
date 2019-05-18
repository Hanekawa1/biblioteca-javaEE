package biblioteca.dal.entidade;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Exemplar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExemplar;
	
	@NotNull(message = "Informe o código do Exemplar")
	private String codigoExemplar;
	
	@ManyToOne
	@JoinColumn(name = "idObra")
	private Obra obra;
	
	@OneToMany(mappedBy = "exemplar")
	private List<Emprestimo> emprestimos;

	public Integer getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(Integer idExemplar) {
		this.idExemplar = idExemplar;
	}

	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public void setCodigoExemplar(String codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExemplar == null) ? 0 : idExemplar.hashCode());
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
		Exemplar other = (Exemplar) obj;
		if (idExemplar == null) {
			if (other.idExemplar != null)
				return false;
		} else if (!idExemplar.equals(other.idExemplar))
			return false;
		return true;
	}
	
}
