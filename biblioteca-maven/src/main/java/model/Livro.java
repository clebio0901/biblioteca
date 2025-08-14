package model;


public class Livro extends Obra {
	public Livro(int codigo, String titulo,String autor, int anoPublicacao, String status) {
		super(codigo, titulo, autor, anoPublicacao, status);
	}

	@Override
	public int getTempoEmprestimo() {
		return (int) 7;
		
	}
}