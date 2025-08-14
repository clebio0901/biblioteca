package model;

public class Artigo extends Obra {
    public Artigo(String codigo, String titulo, String autor, int anoPublicacao, String status) {
        super(codigo, titulo, autor, anoPublicacao, status);
    }

    public Artigo(String codigo, String titulo, String autor, int ano) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public int getTempoEmprestimo() {
        return (int) 2;
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
