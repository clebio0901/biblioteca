package model;

public class Servidor extends Usuario{
	public Servidor(String nome, String matricula, String telefone, String email) {
		super(nome, matricula, telefone, email);
	}

	@Override
	public String getTipo() {
		return "Servidor";
	}

}