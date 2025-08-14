package model;


public class Professor extends Usuario{
	public Professor(String nome, String matricula, String telefone, String email) {
		super(nome, matricula, telefone, email);
	}

	@Override
	public String getTipo() {
		return "Professor";
	}

}
