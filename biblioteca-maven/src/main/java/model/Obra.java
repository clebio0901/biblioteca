package model;

public abstract class Obra {
	private int codigo;
	public String titulo;
	private String autor;
	private int anoPublicacao;
	private String status;
	protected String type;
	
	public Obra() {
		this.codigo = 0;
		this.titulo = "";
		this.autor = "";
		this.anoPublicacao = 0;
		this.status = "";
	}
	public Obra(int codigo, String titulo, String autor, int anoPublicacao, String status) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.status = status;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public abstract int getTempoEmprestimo();
	
	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}
}
	