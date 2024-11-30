package views;

import controllers.ProfessorController;
import java.util.Scanner;

public class ProfessorView {

    public static void enviarMenuProfessor() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibir menu
            System.out.println("\nMenu de Professor");
            System.out.println(" ");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Editar Professor");
            System.out.println("3. Excluir Professor");
            System.out.println("5. Consultar Professor");
            System.out.println("6. Voltar");
            System.out.println(" ");

            // Validar entrada numérica
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha pendente

            // Processar opção escolhida
            switch (opcao) {
                case 1:
                    Utilidades.limparMensagens();
                    ProfessorController.cadastrarProfessor();
                    break;
                case 2:
                    Utilidades.limparMensagens();
                    System.out.print("Digite o nome do professor para editar: ");
                    String nomeParaEditar = scanner.nextLine();
                    ProfessorController.editarProfessor(nomeParaEditar);
                    break;
                case 3:
                    Utilidades.limparMensagens();
                    System.out.print("Digite o nome do professor para excluir: ");
                    String nomeParaExcluir = scanner.nextLine();
                    ProfessorController.excluirProfessor(nomeParaExcluir);
                    break;
                case 4:
                    Utilidades.limparMensagens();
                    System.out.print("Digite o nome do professor para consultar: ");
                    String nomeParaConsultar = scanner.nextLine();
                    consultarProfessor(nomeParaConsultar);
                    break;
                case 5:
                    System.out.println("\nEncerrando o sistema...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void consultarProfessor(String nomeProfessor) {
        if (ProfessorController.procurarProfessor(nomeProfessor)) {
            ProfessorController.buscarProfessorPorNome(nomeProfessor).exibirDados();
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public static void main(String[] args) {
        iniciarSistema(); // Iniciar o sistema
    }
}