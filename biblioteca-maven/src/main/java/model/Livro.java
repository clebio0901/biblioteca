package model;


public class Livro extends Obra {
	public Livro(String codigo, String titulo,String autor, int anoPublicacao, String status) {
		super(codigo, titulo, autor, anoPublicacao, status);
	}

	public Livro(String codigo, String titulo, String autor, int ano) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTempoEmprestimo() {
		return (int) 7;
		
	}

	@Override
	public void setEmprestada(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmprestada() {
		// TODO Auto-generated method stub
		return false;
	}
}
