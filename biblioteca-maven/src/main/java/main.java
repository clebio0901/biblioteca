package View1;

import controller.EmprestimoController;
import controller.ObraController;
import controller.UsuarioController;
import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ObraController obraController = new ObraController();
        UsuarioController usuarioController = new UsuarioController();
        EmprestimoController emprestimoController = new EmprestimoController();

        while (true) {
            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("1. Cadastrar obra");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Registrar devolução");
            System.out.println("5. Listar obras");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tipo (1=Livro, 2=Revista, 3=Artigo): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Obra obra = switch (tipo) {
                        case 1 -> new Livro(codigo, titulo, autor, ano);
                        case 2 -> new Revista(codigo, titulo, autor, ano);
                        case 3 -> new Artigo(codigo, titulo, autor, ano);
                        default -> null;
                    };

                    if (obra != null) {
                        obraController.adicionarObra(obra);
                        System.out.println("Obra cadastrada com sucesso!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                }
                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();
                    System.out.print("Tipo (1=Aluno, 2=Professor, 3=Servidor): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario = switch (tipo) {
                        case 1 -> new Aluno(nome, matricula, telefone, email);
                        case 2 -> new Professor(nome, matricula, telefone, email);
                        case 3 -> new Servidor(nome, matricula, telefone, email);
                        default -> null;
                    };

                    if (usuario != null) {
                        usuarioController.adicionarUsuario(usuario);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                }
                case 3 -> {
                    System.out.print("Código da obra: ");
                    String codigoObra = sc.nextLine();
                    Obra obra = obraController.buscarPorCodigo(codigoObra);

                    if (obra == null || obra.isEmprestada()) {
                        System.out.println("Obra não disponível.");
                        continue;
                    }

                    System.out.print("Matrícula do usuário: ");
                    String matricula = sc.nextLine();
                    Usuario usuario = usuarioController.buscarPorMatricula(matricula);

                    if (usuario == null) {
                        System.out.println("Usuário não encontrado.");
                        continue;
                    }

                    emprestimoController.realizarEmprestimo(obra, usuario);
                    System.out.println("Empréstimo realizado com sucesso!");
                }
                case 4 -> {
                    System.out.print("Código da obra: ");
                    String codigoObra = sc.nextLine();
                    emprestimoController.registrarDevolucao(codigoObra);
                }
                case 5 -> obraController.listarObras();
                case 6 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
