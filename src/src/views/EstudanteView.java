package views;

import controllers.EstudanteController;
import models.Estudante;

import java.util.Scanner;

public class EstudanteView {
    public static Estudante estudante;

    public static void enviarMenuAluno() {
        Utilidades.limparMensagens();
        System.out.println("Menu de alunos:");
        System.out.println(" ");
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Consultar aluno");
        System.out.println("3. editar aluno");
        System.out.println("4. excluir aluno");
        System.out.println("5. Voltar ao menu principal");

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
                    //implmentar
                    break;
                case 4:
                    //implmentar
                    break;
                case 5:
                    //implmentar
                    break;
                default:
                    System.out.println("A opção informada não foi encontrada.");
            }
        } while(opcao <= 0 || opcao >= 4);
    }
}
