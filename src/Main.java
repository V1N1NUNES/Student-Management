package src;

import java.util.Scanner;

public class Main {
    public static void Main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {

            System.out.println("MENU PRINCIPAL\n\n[1] Menu Estudante\n[2] Menu Professor\n[3] Menu Cursos\n[4] Sair");
            System.out.println("\nEscolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // menu estudante
                    break;
                case 2:
                    // menu professor
                    break;
                case 3:
                    // menu cursos
                    break;
                case 4:
                    System.out.println("\nSaindo do programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        sc.close();
    }
}