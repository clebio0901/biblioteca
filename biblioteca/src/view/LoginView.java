package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends Application {

    @Override
    public void start(Stage stage) {
        Label lbl = new Label("Selecione o perfil:");
        ComboBox<String> cbPerfil = new ComboBox<>();
        cbPerfil.getItems().addAll("Administrador", "Bibliotecário", "Estagiário");
        cbPerfil.getSelectionModel().selectFirst();

        Button btnEntrar = new Button("Entrar");

        btnEntrar.setOnAction(e -> {
            String perfil = cbPerfil.getValue();
            MainView mainView = new MainView(perfil);
            try {
                mainView.start(new Stage());
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox vbox = new VBox(10, lbl, cbPerfil, btnEntrar);
        vbox.setPadding(new Insets(20));
        Scene scene = new Scene(vbox, 300, 180);

        stage.setTitle("Login - Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    // Método main para testes locais
    public static void main(String[] args) {
        launch(args);
    }
}
