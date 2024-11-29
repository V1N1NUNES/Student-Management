package controllers;

import models.Estudante;
import views.EstudanteView;
import views.Utilidades;

import java.util.Scanner;

public class EstudanteController {
    public static void cadastrarEstudante() {
        String nomeDoEstudante;
        String matricula;
        int idade;

        Scanner scanner = new Scanner(System.in);

        Utilidades.limparMensagens();
        System.out.println("Digite o nome do estudante: ");
        nomeDoEstudante = scanner.nextLine();

        do {
            Utilidades.limparMensagens();
            System.out.println("Digite a idade do estudante (maior que 0 e menor que 130): ");
            idade = scanner.nextInt();
        } while(idade <= 0 || idade > 130);

        Utilidades.limparMensagens();
        System.out.println("Digite a matricula do estudante: ");
        matricula = scanner.next();

        Estudante.estudantes.add(new Estudante(nomeDoEstudante.trim(), idade, matricula.trim()));

        Utilidades.limparMensagens();
        System.out.println("O estudante " + nomeDoEstudante.trim() + " foi cadastrado com sucesso!");
        EstudanteView.enviarMenuAluno();
    }

    public static void consultarEstudante() {
        Scanner scanner = new Scanner(System.in);
        String matriculaEstudante;
        Estudante estudanteAlvo = null;

        System.out.println("Digite a matrícula do estudante: ");
        matriculaEstudante = scanner.nextLine();

        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        if (estudanteAlvo != null) {
            int opcao;

            System.out.println("Opções do estudante " + estudanteAlvo.getNome() + ":");
            System.out.println("1. Editar estudante");
            System.out.println("2. Excluir estudante");
            System.out.println("3. Cancelar");

            opcao = scanner.nextInt();

            do {
                switch(opcao) {
                    case 1:
                        String novoNome;
                        int idade;
                        String matricula;

                        System.out.println("Digite o novo nome do estudante: ");
                        novoNome = scanner.next();

                        System.out.println("Digite a nova idade do estudante: ");
                        idade = scanner.nextInt();

                        System.out.println("Digite a nova matrícula do estudante: ");
                        matricula = scanner.next();

                        estudanteAlvo.setNome(novoNome);
                        estudanteAlvo.setIdade(idade);
                        estudanteAlvo.setMatricula(matricula);
                        System.out.println("As informações do estudante foram atualizadas.");
                        System.out.println("Pressione a tecla ENTER para retornar ao menu de estudantes...");
                        scanner.nextLine();
                        EstudanteView.enviarMenuAluno();
                        break;
                    case 2:
                        Estudante.estudantes.remove(estudanteAlvo);
                        System.out.println("O estudante foi excluído com sucesso.");
                        break;
                    default:
                        EstudanteView.enviarMenuAluno();
                        System.out.println(" ");
                        System.out.println("A opção informada anteriormente não existe...");
                }
            }while(opcao <= 0 || opcao > 3);
        }
    }

    public static void editarEstudante(){
        //implementar
    }

    public static void excluirEstudante(){
        //implementar
    }
}
