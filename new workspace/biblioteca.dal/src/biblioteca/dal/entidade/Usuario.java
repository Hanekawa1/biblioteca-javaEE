package biblioteca.dal.entidade;

import javax.persistence.*;

@Entity
public class Usuario {

	@Id
	@Column(name = "idPessoaUsuario", insertable = false, updatable = false)
	private Integer idPessoaUsuario;
	
	private String login;
	
	private String senha;
	
	@OneToOne
	@JoinColumn(name = "idPessoaUsuario", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	public Integer getIdPessoaUsuario() {
		return idPessoaUsuario;
	}

	public void setIdPessoaUsuario(Integer idPessoaUsuario) {
		this.idPessoaUsuario = idPessoaUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
