package views;

import controllers.CursoController;

import java.util.Scanner;

public class CursoView {

    public static void enviarMenuCurso() {
        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n== Menu de Cursos ==");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Consultar Curso");
            System.out.println("3. Editar Curso");
            System.out.println("4. Excluir Curso");
            System.out.println("5. Voltar para o Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    CursoController.cadastrarCurso();
                    break;
                case 2:
                    CursoController.consultarCurso();
                    break;
                case 3:
                    CursoController.editarCurso();
                    break;
                case 4:
                    CursoController.excluirCurso();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    Main.enviarMenu();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    public static void menuEdicao(String nomeCurso) {
        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n== Menu de Edição do Curso: " + nomeCurso + " ==");
            System.out.println("1. Alterar Nome");
            System.out.println("2. Alterar Carga Horária");
            System.out.println("3. Alterar Professor Ministrante");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = leitura.nextInt();
            leitura.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    CursoController.alterarNome(nomeCurso);
                    break;
                case 2:
                    CursoController.alterarCargaHoraria(nomeCurso);
                    break;
                case 3:
                    CursoController.alterarProfessor(nomeCurso);
                    break;
                case 4:
                    System.out.println("Voltando ao Menu de Cursos...");
                    CursoView.enviarMenuCurso();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}