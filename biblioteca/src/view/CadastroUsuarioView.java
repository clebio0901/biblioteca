package view;

import controller.BibliotecaController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Usuario;

public class CadastroUsuarioView {

    private final BibliotecaController controller;

    public CadastroUsuarioView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Usuário");

        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome completo");

        TextField txtMatricula = new TextField();
        txtMatricula.setPromptText("Matrícula");

        ComboBox<String> cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll("aluno", "professor", "servidor");
        cbTipo.getSelectionModel().selectFirst();

        TextField txtTelefone = new TextField();
        txtTelefone.setPromptText("Telefone");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("E-mail");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction(e -> {
            String nome = txtNome.getText();
            String matricula = txtMatricula.getText();
            String tipo = cbTipo.getValue();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();

            if (nome.isEmpty() || matricula.isEmpty()) {
                showAlert("Campos obrigatórios não preenchidos.");
                return;
            }

            Usuario usuario = new Usuario(nome, matricula, tipo, telefone, email);
            controller.cadastrarUsuario(usuario);
            showAlert("Usuário cadastrado com sucesso!");
            stage.close();
        });

        VBox vbox = new VBox(10,
                new Label("Nome:"), txtNome,
                new Label("Matrícula:"), txtMatricula,
                new Label("Tipo de usuário:"), cbTipo,
                new Label("Telefone:"), txtTelefone,
                new Label("E-mail:"), txtEmail,
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
