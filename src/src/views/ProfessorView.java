package views;

import controllers.ProfessorController;
import java.util.Scanner;

public class ProfessorView {

    public static void enviarMenuProfessor() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibir menu
            System.out.println("\n=== Sistema de Gerenciamento de Professores ===");
            System.out.println("[1] Cadastrar Professor");
            System.out.println("[2] Editar Professor");
            System.out.println("[3] Excluir Professor");
            System.out.println("[4] Consultar Professor");
            System.out.println("[5] Sair");
            System.out.println("==============================================");
            System.out.print("Escolha uma opção: ");

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
                    ProfessorController.cadastrarProfessor();
                    break;
                case 2:
                    System.out.print("Digite o nome do professor para editar: ");
                    String nomeParaEditar = scanner.nextLine();
                    ProfessorController.editarProfessor(nomeParaEditar);
                    break;
                case 3:
                    System.out.print("Digite o nome do professor para excluir: ");
                    String nomeParaExcluir = scanner.nextLine();
                    ProfessorController.excluirProfessor(nomeParaExcluir);
                    break;
                case 4:
                    System.out.print("Digite o nome do professor para consultar: ");
                    String nomeParaConsultar = scanner.nextLine();
                    consultarProfessor(nomeParaConsultar);
                    break;
                case 5:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
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
        enviarMenuProfessor(); // Iniciar o sistema
    }
}