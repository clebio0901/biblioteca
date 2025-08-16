package model;

public class Artigo extends Obra {
    public Artigo(String codigo, String titulo, String autor, int anoPublicacao, String status) {
        super(codigo, titulo, autor, anoPublicacao, status);
    }

    public Artigo(String codigo, String titulo, String autor, int ano) {
		
	}

	@Override
    public int getTempoEmprestimo() {
        return (int) 2;
    }

	@Override
	public void setEmprestada(boolean b) {
		
		
	}

	@Override
	public boolean isEmprestada() {
		
		return false;
	}
}

