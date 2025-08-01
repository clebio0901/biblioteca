package view;

import controller.BibliotecaController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

    private final String perfil;
    private final BibliotecaController controller;

    public MainView(String perfil) {
        this.perfil = perfil;
        this.controller = new BibliotecaController();
    }

    public void start(Stage stage) {
        stage.setTitle("Sistema Biblioteca - Perfil: " + perfil);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        if (perfil.equalsIgnoreCase("Administrador")) {
            Button btnCadUsuario = new Button("Cadastrar Usuário");
            btnCadUsuario.setOnAction(e -> new CadastroUsuarioView(controller).exibir());

            Button btnCadObra = new Button("Cadastrar Obra");
            btnCadObra.setOnAction(e -> new CadastroObraView(controller).exibir());

            vbox.getChildren().addAll(btnCadUsuario, btnCadObra);
        }

        if (perfil.equalsIgnoreCase("Administrador") || perfil.equalsIgnoreCase("Bibliotecário")) {
            Button btnEmprestar = new Button("Realizar Empréstimo");
            btnEmprestar.setOnAction(e -> new EmprestimoView(controller).exibir());

            Button btnRelatorios = new Button("Relatórios");
            btnRelatorios.setOnAction(e -> new RelatoriosView(controller).exibir());

            vbox.getChildren().addAll(btnEmprestar, btnRelatorios);
        }

        Button btnDevolver = new Button("Registrar Devolução");
        btnDevolver.setOnAction(e -> {
            // Você pode criar uma DevolucaoView futuramente
        });

        vbox.getChildren().add(btnDevolver);

        Scene scene = new Scene(vbox, 350, 250);
        stage.setScene(scene);
        stage.show();
    }
}
