package model;

public class Aluno extends Usuario{
	public Aluno(String nome, String matricula, String telefone, String email) {
		super(nome, matricula, telefone, email);
	}

	@Override
	public String getTipo() {
		return "Aluno";
	}

}