package model;

public class Bibliotecario extends Funcionario{
	
	public Bibliotecario(String login, String senha) {
		super(login, senha);
	}
	@Override
	public String getTipo() {
		return "bibliotecario";
	}
	@Override
	public String toString() {
		return "[Bibliotecário] Login: " + getLogin();
	}


}