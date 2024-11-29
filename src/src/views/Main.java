package views;

import java.util.Scanner;

public class Main {

    public static void enviarMenu() {
        Scanner scanner = new Scanner(System.in);

        Utilidades.limparMensagens();
        System.out.println("Gerenciamento Estudantil");
        System.out.println(" ");
        System.out.println("1. Menu de alunos");
        System.out.println("2. Menu de professor");
        System.out.println("3. Menu de curso");
        System.out.println("4. Menu de relatórios");
        System.out.println("5. Sair do programa");
        System.out.println(" ");

        int opcao = scanner.nextInt();

        do {
            switch(opcao) {
                case 1:
                    EstudanteView.enviarMenuAluno();
                    break;
                case 2:
                    ProfessorView.enviarMenuProfessor();
                    break;
                case 3:
                    CursoView.enviarMenuCurso();
                    break;
                case 4:
                    Relatorios.enviarRelatorios();
                    break;
                case 5:
                    //encerrar o programa
                    break;
                default:
                    System.out.println("A opção informada não é válida.");
                    enviarMenu();
                    break;
            }
        }while(opcao <= 0 || opcao >= 6);
    }

    public static void main(String[] args) {
        enviarMenu();
    }
}