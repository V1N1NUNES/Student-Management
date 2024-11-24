package controllers;

import java.util.Scanner;
import services.Professor_functions;

public class Interface_Professor {
    public void Interface(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a interface de professor! ");

        System.out.println("Digite o numero da opção desejada (Digite 6 para sair): ");
        System.out.println("1- Cadastrar um novo professor \n2- Listar professores \n3- Consultar professor\n4- Editar professor \n5- Excluir professor");
        int entrada = scanner.nextInt();


        switch(entrada){

            case 1:
                Professor_functions.cadastrarProfessor();
                break;

            case 2:
                Professor_functions.listarProfessores();
                break;

            case 3:
                Professor_functions.consultarProfessor();
                break;

            case 4:
                Professor_functions.editarProfessor();
                break;

            case 5:
                Professor_functions.excluirProfessor();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + entrada);
        }
    }
}
