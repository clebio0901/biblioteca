package model;

public class Funcionario {
    private String login;
    private String senha;
    
    public Funcionario() {
    	this.login = "";
    	this.senha = "";
    }

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
    	this.login = login;
    }
    public String getSenha() {
    	return senha;
    }
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
    
    public String getTipo() {
    	return "Funcionário";
    }
    
    public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }
    
    public String toString() {
        return "[Tipo: " + getTipo() + "] Login: " + login;
    }
    
}