package src.view;

import src.controllers.AlunoController;
import src.controllers.ProfessorController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().menuPrincipal();
    }

    ProfessorController professorController = new ProfessorController();
    AlunoController alunoController = new AlunoController();

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n== MENU PRINCIPAL ==\n");
            System.out.println("[1] Menu Aluno");
            System.out.println("[2] Menu Professor");
            System.out.println("[3] Menu Cursos");
            System.out.println("[4] Sair");

            System.out.print("\nOpção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer após nextInt()

            switch (opcao) {
                case 1:
                    alunoController.menuAlunos();
                    break;
                case 2:
                    professorController.menuProfessor();
                    break;
                case 3:
                    // menuCursos(sc);
                    break;
                case 4:
                    System.out.println("\nSaindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        sc.close();
    }
}