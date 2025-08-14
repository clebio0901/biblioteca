package model;
import java.time.LocalDate;


class Multa {
    private int id;
    private double valorPago;
    private LocalDate dataPagamento;
    private Pagamento metodo;
    private Usuario usuario;

    public Multa(int id, double valorPago, LocalDate dataPagamento, Pagamento metodo, Usuario usuario) {
        this.id = id;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.metodo = metodo;
        this.usuario = usuario;
    }

    public Multa(double d) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public Pagamento getMetodo() {
        return metodo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Pagamento ID: " + id +
               ", Valor: R$" + valorPago +
               ", Data: " + dataPagamento +
               ", Método: " + metodo +
               ", Usuário: [" + usuario + "]";
    }
}
/*
public class SistemaMultas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<PagamentoMulta> pagamentos = new ArrayList<>();

        // Criando usuários de exemplo
        Usuario usuario1 = new Usuario(1, "João Silva");
        Usuario usuario2 = new Usuario(2, "Maria Oliveira");

        // Adicionando alguns pagamentos
        pagamentos.add(new PagamentoMulta(101, 250.0, LocalDate.now(), MetodoPagamento.PIX, usuario1));
        pagamentos.add(new PagamentoMulta(102, 120.0, LocalDate.now().minusDays(1), MetodoPagamento.CARTAO, usuario2));

        // Exibindo os pagamentos
        System.out.println("=== REGISTRO DE PAGAMENTOS DE MULTAS ===");
        for (PagamentoMulta pagamento : pagamentos) {
            System.out.println(pagamento);
        }

        input.close();
    }
}
*/