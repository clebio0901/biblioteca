package view;

import controller.BibliotecaController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Artigo;
import model.Livro;
import model.Obra;
import model.Revista;

public class CadastroObraView {

    private final BibliotecaController controller;

    public CadastroObraView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Obra");

        TextField txtCodigo = new TextField();
        txtCodigo.setPromptText("Código");

        TextField txtTitulo = new TextField();
        txtTitulo.setPromptText("Título");

        TextField txtAutor = new TextField();
        txtAutor.setPromptText("Autor");

        TextField txtAno = new TextField();
        txtAno.setPromptText("Ano de publicação");

        ComboBox<String> cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll("Livro", "Revista", "Artigo");
        cbTipo.getSelectionModel().selectFirst();

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction(e -> {
            try {
                String codigo = txtCodigo.getText();
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                int ano = Integer.parseInt(txtAno.getText());
                String tipo = cbTipo.getValue();

                if (codigo.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
                    showAlert("Todos os campos devem ser preenchidos.");
                    return;
                }

                Obra obra;
                switch (tipo) {
                    case "Livro" -> obra = new Livro(codigo, titulo, autor, ano);
                    case "Revista" -> obra = new Revista(codigo, titulo, autor, ano);
                    case "Artigo" -> obra = new Artigo(codigo, titulo, autor, ano);
                    default -> throw new IllegalStateException("Tipo desconhecido");
                }

                controller.cadastrarObra(obra);
                showAlert("Obra cadastrada com sucesso!");
                stage.close();
            } catch (NumberFormatException ex) {
                showAlert("Ano de publicação inválido.");
            } catch (Exception ex) {
                showAlert("Erro: " + ex.getMessage());
            }
        });

        VBox vbox = new VBox(10,
                new Label("Código:"), txtCodigo,
                new Label("Título:"), txtTitulo,
                new Label("Autor:"), txtAutor,
                new Label("Ano:"), txtAno,
                new Label("Tipo:"), cbTipo,
                btnSalvar
        );
        vbox.setPadding(new Insets(20));

        stage.setScene(new Scene(vbox, 350, 400));
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
