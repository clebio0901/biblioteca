package dao;

import java.time.LocalDate;

import model.Usuario;

public class MultaDAO{
    private String id;
    private double valor;
    private LocalDate dataPagamento;
    private String metodoPagamento;
    private Usuario usuario;

    public MultaDAO(String id, double valor, LocalDate dataPagamento, String metodoPagamento, Usuario usuario) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
        this.usuario = usuario;
    }

    public String getId() { return id; }
    public double getValor() { return valor; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public Usuario getUsuario() { return usuario; }
}
