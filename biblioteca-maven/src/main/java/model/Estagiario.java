package model;

public class Estagiario extends Funcionario{
	
	public Estagiario(String login, String senha) {
		super(login, senha);
	}
	@Override
	public String getTipo() {
		return "estagiario";
	}
	@Override
	public String toString() {
		return "[Estagiário] Login: " + getLogin();
	}
}