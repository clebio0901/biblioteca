package model;

public class Revista extends Obra {
    public Revista(int codigo, String titulo, String autor, int anoPublicacao, String status) {
        super(codigo, titulo, autor, anoPublicacao, status);
    }

    @Override
    public int getTempoEmprestimo() {
        return (int) 3;
    }
}