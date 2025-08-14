package model;

import java.time.LocalDate;

public class Emprestimo {
    private Obra obra;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private boolean devolvido;

    public Emprestimo(Obra obra, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataPrevista) {
        this.obra = obra;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(obra.getTempoEmprestimo());
        this.devolvido = false;
       // obra.emprestar();
    }

    public void marcarComoDevolvido() {
        devolvido = true;
        //obra.devolver();
    }

    public boolean estaAtrasado(LocalDate dataAtual) {
        return !devolvido && dataAtual.isAfter(dataPrevistaDevolucao);
    }

    public Obra getObra() { return obra; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public boolean isDevolvido() { return devolvido; }

	public void setDataDevolucao1(LocalDate now) {
		
		
	}

	public void setDataDevolucao(LocalDate now) {
		
	}
}
