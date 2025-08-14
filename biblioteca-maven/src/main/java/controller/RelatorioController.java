package controller;

import model.Biblioteca;
import model.Emprestimo;
import model.Obra;
import model.Usuario;

public class RelatorioController {
    private final Biblioteca biblioteca;

    public RelatorioController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String listarUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : biblioteca.getUsuarios()) {
            sb.append("Nome: ").append(usuario.getNome())
              .append(" | Matrícula: ").append(usuario.getMatricula())
              .append("\n");
        }
        return sb.toString();
    }

    public String listarObras() {
        StringBuilder sb = new StringBuilder();
        for (Obra obra : biblioteca.getObras()) {
            sb.append("Título: ").append(obra.getTitulo())
              .append(" | Autor: ").append(obra.getAutor())
              .append(" | Código: ").append(obra.getCodigo())
              .append("\n");
        }
        return sb.toString();
    }

    public String listarEmprestimos() {
        StringBuilder sb = new StringBuilder();
        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            sb.append("Usuário: ").append(emprestimo.getUsuario().getNome())
              .append(" | Obra: ").append(emprestimo.getObra().getTitulo())
              .append(" | Data: ").append(emprestimo.getDataEmprestimo())
              .append("\n");
        }
        return sb.toString();
    }
}
