package views;

import controllers.EstudanteController;
import models.Estudante;

import java.util.Scanner;

public class EstudanteView {
    public static Estudante estudante;

    public static void enviarMenuAluno() {

        System.out.println("\n\n == Menu de Aluno ==");
        System.out.println(" ");
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Consultar aluno");
        System.out.println("3. Editar aluno");
        System.out.println("4. Excluir aluno");
        System.out.println("5. Voltar");
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        do {
            switch(opcao) {
                case 1:
                    EstudanteController.cadastrarEstudante();
                    break;
                case 2:
                    EstudanteController.consultarEstudante();
                    break;
                case 3:
                    EstudanteController.editarEstudante();
                    break;
                case 4:
                    EstudanteController.excluirEstudante();
                    break;
                case 5:
                    Main.enviarMenu();
                    break;
                default:
                    System.out.println("\nA opção informada não é válida.");
                    enviarMenuAluno();
            }
        } while(opcao <= 0 || opcao >= 4);
    }
}