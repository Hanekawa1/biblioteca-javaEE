package biblioteca.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Obra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idObra;
	
	@NotNull(message = "Informe a Editora da obra")
	@ManyToOne
	@JoinColumn(name = "idEditora")
	private Editora editora;
	
	@NotNull(message = "Informe o Tipo da obra")
	@ManyToOne
	@JoinColumn(name = "idTipoObra")
	private TipoObra tipoObra;
	
	@ManyToMany
	@JoinTable(name = "AutorObra", 
				joinColumns = @JoinColumn(name = "idObra"),
				inverseJoinColumns = @JoinColumn(name = "idAutor"))
	private List<Autor> autores;
	
	@ManyToMany
	@JoinTable(name = "GeneroObra",
				joinColumns = @JoinColumn(name = "idObra"),
				inverseJoinColumns = @JoinColumn(name = "idGenero"))
	private List<Genero> generos;
	
	@OneToMany(mappedBy = "obra")
	private List<Exemplar> exemplares;
	
	private String nomeObra;
	
	//Getters & Setters
	
	public String getNomeObra() {
		return nomeObra;
	}

	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}

	public Integer getIdObra() {
		return idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public TipoObra getTipoObra() {
		return tipoObra;
	}

	public void setTipoObra(TipoObra tipoObra) {
		this.tipoObra = tipoObra;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	
	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	
	//HashCode & Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Obra other = (Obra) obj;
		if (idObra == null) {
			if (other.idObra != null)
				return false;
		} else if (!idObra.equals(other.idObra))
			return false;
		return true;
	}
}
