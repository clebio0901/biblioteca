package model;

public abstract class Usuario {
	private String nome;
	private String matricula;
	private String telefone;
	private String email;
	
	
	public Usuario() {
		this.nome = "";
		this.matricula = "";
		this.telefone = "";
		this.email = "";
	}
	public Usuario (String nome, String matricula, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void gsetMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String gettTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public abstract String getTipo(); 
	
	public String toString() {
		return "[" + getTipo() + "] " + nome + 
				"\n | Matrícula: " + matricula + 
				"\n | Tel: " + telefone + 
				"\n | Email: " + email;
	}
}