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
            System.out.println("1. alterar nome do curso\n");
            System.out.println("2. alterar carga horária\n");
            System.out.println("3. alterar professor ministrante\n");
            System.out.println("4. voltar ao menu de cursos\n");
            opcao = leitura.nextInt();

            switch(opcao){
                case 1:
                    CursoController.alterarNome();
                    break;
                case 2:
                    CursoController.alterarCargaHoraria();
                    break;
                case 3:
                    CursoController.alterarProfessor();
                    break;
                case 4:
                    CursoView.enviarMenuCurso();
                    break;
                default:
                    break;
            }
        }while(opcao != 4);

        leitura.close();
    }
}
