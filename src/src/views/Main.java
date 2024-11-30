package views;

import java.util.Scanner;

public class Main {

    public static void enviarMenu() {
        Scanner scanner = new Scanner(System.in);

        Utilidades.limparMensagens();
        System.out.println("Gerenciamento Estudantil");
        System.out.println(" ");
        System.out.println("1. Menu de Alunos");
        System.out.println("2. Menu de Professor");
        System.out.println("3. Menu de Curso");
        System.out.println("4. Menu de Relatórios");
        System.out.println("5. Sair do Programa");
        System.out.println(" ");

        int opcao = scanner.nextInt();

        do {
            switch(opcao) {
                case 1:
                    Utilidades.limparMensagens();
                    EstudanteView.enviarMenuAluno();
                    break;
                case 2:
                    Utilidades.limparMensagens();
                    ProfessorView.enviarMenuProfessor();
                    break;
                case 3:
                    Utilidades.limparMensagens();
                    CursoView.enviarMenuCurso();
                    break;
                case 4:
                    Utilidades.limparMensagens();
                    Relatorios.enviarRelatorios();
                    break;
                case 5:
                    System.out.println("\nEncerrando o programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nA opção informada não é válida.");
                    enviarMenu();
                    break;
            }
        } while(opcao <= 0 || opcao >= 6);
    }

    public static void main(String[] args) {
        enviarMenu();
    }
}