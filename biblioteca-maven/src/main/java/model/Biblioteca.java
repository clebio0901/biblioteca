package model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Usuario> usuarios;
    private List<Obra> obras;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.usuarios = new ArrayList<Usuario>();
        this.obras = new ArrayList<Obra>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    // Métodos para adicionar elementos
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarObra(Obra obra) {
        obras.add(obra);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }
}
