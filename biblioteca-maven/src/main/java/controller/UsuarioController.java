package controller;

import model.Usuario;
 

import java.util.ArrayList;
import model.Usuario;

public class UsuarioController {
    private ArrayList<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<Usuario>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        for (Usuario usuarioExistente : usuarios) {
            if (usuarioExistente.getMatricula().equals(usuario.getMatricula())) {
                System.out.println("Erro: matrícula já cadastrada.");
                return;
            }
        }
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    public void editarUsuario(String matricula, String novoNome, String novoTelefone, String novoEmail) {
        for (Usuario usuarioExistente : usuarios) {
            if (usuarioExistente.getMatricula().equals(matricula)) {
                usuarioExistente.setNome(novoNome);
                usuarioExistente.setTelefone(novoTelefone);
                usuarioExistente.setEmail(novoEmail);
                System.out.println("Usuário editado com sucesso.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void excluirUsuario(String matricula) {
        for (Usuario usuarioExistente : usuarios) {
            if (usuarioExistente.getMatricula().equals(matricula)) {
                usuarios.remove(usuarioExistente);
                System.out.println("Usuário removido com sucesso.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario usuarioExistente : usuarios) {
            System.out.println("Usuario: " + usuarioExistente);
        }
    }
}