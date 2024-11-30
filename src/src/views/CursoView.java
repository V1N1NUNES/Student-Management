package views;

import controllers.CursoController;

import java.util.Scanner;

public class CursoView {
    public static void enviarMenuCurso(){
        Scanner leitura = new Scanner(System.in);
        int opcao;

        System.out.println("== Menu de cursos ==");
        System.out.println("1. Cadastrar Curso");
        System.out.println("2. Consultar Curso");
        System.out.println("3. Editar Curso");
        System.out.println("4. Excluir Curso");
        System.out.println("5. Voltar para o Menu principal.");

        opcao = leitura.nextInt();

        if(opcao <= 0 || opcao >= 6){
            System.out.println("Número digitado inválido.");
        }

        else{
            switch(opcao){
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
                    System.out.println("Voltando para o Menu principal.");
                    Main.enviarMenu();
                    break;
            }
        }
    }

    public static void menuEdicao(){
        Scanner leitura = new Scanner(System.in);
        int opcao;
        String nomeCurso;

        do{
            System.out.println("1. Alterar nome do curso");
            System.out.println("2. Alterar carga horária");
            System.out.println("3. Alterar professor ministrante");
            System.out.println("4. Voltar");
            System.out.println(" ");

            opcao = leitura.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Digite o nome do curso:");
                    nomeCurso = leitura.next();

                    CursoController.alterarNome(nomeCurso);
                    break;

                case 2:
                    System.out.println("Digite o nome do curso:");
                    nomeCurso = leitura.next();

                    CursoController.alterarCargaHoraria(nomeCurso);
                    break;

                case 3:
                    System.out.println("Digite o nome do curso:");
                    nomeCurso = leitura.next();

                    CursoController.alterarProfessor(nomeCurso);
                    break;

                case 4:
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