package view;

import controller.BibliotecaController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Emprestimo;
import model.PagamentoMulta;

import java.util.List;

public class RelatoriosView {

    private final BibliotecaController controller;

    public RelatoriosView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Relatórios");

        TextArea areaRelatorio = new TextArea();
        areaRelatorio.setEditable(false);
        areaRelatorio.setWrapText(true);

        Button btnEmprestimos = new Button("Empréstimos Ativos");
        btnEmprestimos.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            for (Emprestimo emp : controller.getEmprestimos()) {
                if (!emp.isDevolvido()) {
                    sb.append("Obra: ").append(emp.getObra().getTitulo())
                      .append(" | Usuário: ").append(emp.getUsuario().getNome())
                      .append(" | Previsto para: ").append(emp.getDataDevolucaoPrevista())
                      .append("\n");
                }
            }
            areaRelatorio.setText(sb.toString());
        });

        Button btnAtrasados = new Button("Empréstimos Atrasados");
        btnAtrasados.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            List<Emprestimo> atrasados = controller.listarAtrasados();
            for (Emprestimo emp : atrasados) {
                sb.append("Obra: ").append(emp.getObra().getTitulo())
                  .append(" | Usuário: ").append(emp.getUsuario().getNome())
                  .append(" | Previsto: ").append(emp.getDataDevolucaoPrevista())
                  .append(" | Hoje: ").append(java.time.LocalDate.now())
                  .append("\n");
            }
            areaRelatorio.setText(sb.toString());
        });

        Button btnPagamentos = new Button("Pagamentos de Multa");
        btnPagamentos.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            for (PagamentoMulta pag : controller.getPagamentos()) {
                sb.append("Usuário: ").append(pag.getUsuario().getNome())
                  .append(" | Valor: R$").append(String.format("%.2f", pag.getValor()))
                  .append(" | Data: ").append(pag.getDataPagamento())
                  .append(" | Método: ").append(pag.getMetodoPagamento())
                  .append("\n");
            }
            areaRelatorio.setText(sb.toString());
        });

        VBox vbox = new VBox(10, btnEmprestimos, btnAtrasados, btnPagamentos, areaRelatorio);
        vbox.setPadding(new Insets(20));

        stage.setScene(new Scene(vbox, 500, 400));
        stage.show();
    }
}
