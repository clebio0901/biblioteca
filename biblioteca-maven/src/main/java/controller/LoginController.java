package controller;

import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class LoginController {
    private List<Funcionario> funcionarios;

    public LoginController() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public void cadastrarFuncionario(Funcionario f) {
        for (Funcionario existente : funcionarios) {
            if (existente.getLogin().equals(f.getLogin())) {
                System.out.println("Login de funcionário já cadastrado!");
                return;
            }
        }
        funcionarios.add(f);
        System.out.println("Funcionário cadastrado com sucesso!");
    }
    
    public void excluirFuncionario(String login) {
        for (Funcionario f : funcionarios) {
            if (f.getLogin().equals(login)) {
                funcionarios.remove(f);
                System.out.println("Funcionário removido com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário com login \"" + login + "\" não encontrado.");
    }


    public Funcionario login(String login, String senha) {
        for (Funcionario f : funcionarios) {
            if (f.getLogin().equals(login)) {
                if (f.autenticar(senha)) {
                    System.out.println("Login realizado com sucesso!");
                    return f;
                } else {
                    System.out.println("Senha incorreta.");
                    return null;
                }
            }
        }
        System.out.println("Login não encontrado.");
        return null;
    }
}