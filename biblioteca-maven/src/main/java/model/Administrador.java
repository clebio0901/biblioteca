package model;

public class Administrador extends Funcionario{
	
	public Administrador(String login, String senha) {
		super(login, senha);
	}
	@Override
	public String getTipo() {
		return "administrador";
	}
	@Override
	public String toString() {
		return "[Administrador] Login: " + getLogin();
	}


}