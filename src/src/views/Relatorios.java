package views;

import controllers.RelatorioController;

import java.util.Scanner;

public class Relatorios {
    public static void enviarRelatorios(){
        Scanner leitura = new Scanner(System.in);
        int opcao;

        System.out.println("Menu de relatórios\n");
        System.out.println("1. Relatório de Estudantes");
        System.out.println("2. Relatório de Professores");
        System.out.println("3. Voltar");

        opcao = leitura.nextInt();
        Utilidades.limparMensagens();

        do{
            switch (opcao){
                case 1:
                    RelatorioController.relatorioDeEstudantes();
                    break;
                case 2:
                    RelatorioController.relatorioDeProfessores();
                    break;
                case 3:
                    Main.enviarMenu();
                    break;
            }
        }while (opcao != 4);
    }
}
