package views;

import controllers.EstudanteController;
import models.Estudante;

import java.util.Scanner;

public class EstudanteView {
    public static Estudante estudante;

    public static void enviarMenuAluno() {
        Utilidades.limparMensagens();

        System.out.println("Menu de Aluno");
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
                    Utilidades.limparMensagens();
                    EstudanteController.cadastrarEstudante();
                    break;
                case 2:
                    Utilidades.limparMensagens();
                    EstudanteController.consultarEstudante();
                    break;
                case 3:
                    Utilidades.limparMensagens();
                    //implmentar
                    break;
                case 4:
                    Utilidades.limparMensagens();
                    //implmentar
                    break;
                case 5:
                    Utilidades.limparMensagens();
                    Main.enviarMenu();
                    break;
                default:
                    System.out.println("\nA opção informada não é válida.");
                    enviarMenuAluno();
            }
        } while(opcao <= 0 || opcao >= 4);
    }
}