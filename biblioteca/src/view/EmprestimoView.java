package view;

import controller.BibliotecaController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Obra;
import model.Usuario;

import java.util.List;

public class EmprestimoView {

    private final BibliotecaController controller;

    public EmprestimoView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Realizar Empréstimo");

        ComboBox<String> cbObras = new ComboBox<>();
        List<Obra> obrasDisponiveis = controller.listarObrasDisponiveis();
        for (Obra o : obrasDisponiveis) {
            cbObras.getItems().add(o.getCodigo() + " - " + o.getTitulo());
        }

        ComboBox<String> cbUsuarios = new ComboBox<>();
        List<Usuario> usuarios = controller.getUsuarios();
        for (Usuario u : usuarios) {
            cbUsuarios.getItems().add(u.getMatricula() + " - " + u.getNome());
        }

        Button btnConfirmar = new Button("Confirmar Empréstimo");
        btnConfirmar.setOnAction(e -> {
            try {
                if (cbObras.getValue() == null || cbUsuarios.getValue() == null) {
                    showAlert("Selecione uma obra e um usuário.");
                    return;
                }

                String codObra = cbObras.getValue().split(" - ")[0];
                String matriculaUsuario = cbUsuarios.getValue().split(" - ")[0];

                controller.realizarEmprestimo(codObra, matriculaUsuario);
                showAlert("Empréstimo realizado com sucesso!");
                stage.close();
            } catch (Exception ex) {
                showAlert("Erro: " + ex.getMessage());
            }
        });

        VBox vbox = new VBox(10,
                new Label("Obra disponível:"), cbObras,
                new Label("Usuário:"), cbUsuarios,
                btnConfirmar
        );
        vbox.setPadding(new Insets(20));

        stage.setScene(new Scene(vbox, 400, 250));
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
