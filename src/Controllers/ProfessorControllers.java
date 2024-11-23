package src.Controllers;

import java.util.Scanner;

public class ProfessorControllers {

    //DUDÁSTICA
    public void MenuProfessor(Scanner leitura){
        int opcao;
        boolean Opcao = true;

        System.out.println("MENU PROFESSOR\n\n1- cadastrar professor\n2- Consultar professor\n3- Editar informações\n4- excluir professor\n5- Menu principal\n");
        opcao = leitura.nextInt();

        do{
            switch (opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Voltando ao Menu principal...\n\n");
                    //Menu principal
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(Opcao == false);
    }
}
