package model;

public class Artigo extends Obra {
    public Artigo(int codigo, String titulo, String autor, int anoPublicacao, String status) {
        super(codigo, titulo, autor, anoPublicacao, status);
    }

    @Override
    public int getTempoEmprestimo() {
        return (int) 2;
    }
}