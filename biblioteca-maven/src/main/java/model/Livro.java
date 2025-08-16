package model;


public class Livro extends Obra {
	public Livro(String codigo, String titulo,String autor, int anoPublicacao, String status) {
		super(codigo, titulo, autor, anoPublicacao, status);
	}

	public Livro(String codigo, String titulo, String autor, int ano) {
		
	}

	@Override
	public int getTempoEmprestimo() {
		return (int) 7;
		
	}

	@Override
	public void setEmprestada(boolean b) {
		
		
	}

	@Override
	public boolean isEmprestada() {
	
		return false;
	}
}

