package views;

import controllers.CursoController;

import java.util.Scanner;

public class CursoView {
    public static void enviarMenuCurso(){
        //implementar menu
    }
    public static void menuEdicao(){
        Scanner leitura = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n Sistema de Gerenciamento de Cursos");
            System.out.println(" ");
            System.out.println("1. Alterar nome do curso\n");
            System.out.println("2. Alterar carga horária\n");
            System.out.println("3. Alterar professor ministrante\n");
            System.out.println("4. Voltar\n");
            System.out.println(" ");

            opcao = leitura.nextInt();

            switch(opcao){
                case 1:
                    Utilidades.limparMensagens();
                    CursoController.alterarNome();
                    break;
                case 2:
                    Utilidades.limparMensagens();
                    CursoController.alterarCargaHoraria();
                    break;
                case 3:
                    Utilidades.limparMensagens();
                    CursoController.alterarProfessor();
                    break;
                case 4:
                    Utilidades.limparMensagens();
                    Main.enviarMenu();
                    break;
                default:
                    System.out.println("\nA opção informada não é válida.");
                    break;
            }
        } while(opcao != 4);

        leitura.close();
    }
}