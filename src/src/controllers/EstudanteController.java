package controllers;

import models.Estudante;
import views.EstudanteView;
import views.Utilidades;

import java.util.Scanner;

public class EstudanteController {

    private static final Scanner scanner = new Scanner(System.in);

    // Função para cadastrar um estudante
    public static void cadastrarEstudante() {
        String nomeDoEstudante;
        String matricula;
        int idade;

        Utilidades.limparMensagens();
        System.out.println("Digite o nome do estudante: ");
        nomeDoEstudante = scanner.nextLine();

        do {
            System.out.println("Digite a idade do estudante (maior que 0 e menor que 130): ");
            idade = Integer.parseInt(scanner.nextLine());
        } while (idade <= 0 || idade > 130);

        System.out.println("Digite a matrícula do estudante: ");
        matricula = scanner.nextLine();

        // Verificar se a matrícula é única
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matricula)) {
                System.out.println("Já existe um estudante com essa matrícula.");
                EstudanteView.enviarMenuAluno();
                return;
            }
        }

        // Adicionar estudante
        Estudante.estudantes.add(new Estudante(nomeDoEstudante.trim(), idade, matricula.trim()));
        System.out.println("O estudante " + nomeDoEstudante + " foi cadastrado com sucesso!");
        EstudanteView.enviarMenuAluno();
    }

    // Consultar estudante
    public static void consultarEstudante() {
        System.out.println("Digite a matrícula do estudante: ");
        String matriculaEstudante = scanner.nextLine();

        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        if (estudanteAlvo != null) {
            System.out.println("Informações do estudante:");
            estudanteAlvo.exibirDados();
        } else {
            System.out.println("Estudante não encontrado.");
        }

        System.out.println("Pressione Enter para voltar ao menu...");
        scanner.nextLine();
        EstudanteView.enviarMenuAluno();
    }

    // Editar informações do estudante
    public static void editarEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja editar: ");
        String matriculaEstudante = scanner.nextLine();

        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        if (estudanteAlvo == null) {
            System.out.println("Estudante não encontrado.");
            EstudanteView.enviarMenuAluno();
            return;
        }

        System.out.println("Digite o novo nome (atualmente: " + estudanteAlvo.getNome() + "): ");
        estudanteAlvo.setNome(scanner.nextLine().trim());

        System.out.println("Digite a nova idade (atualmente: " + estudanteAlvo.getIdade() + "): ");
        estudanteAlvo.setIdade(Integer.parseInt(scanner.nextLine()));

        System.out.println("Digite a nova matrícula (atualmente: " + estudanteAlvo.getMatricula() + "): ");
        estudanteAlvo.setMatricula(scanner.nextLine().trim());

        System.out.println("As informações do estudante foram atualizadas com sucesso!");
        EstudanteView.enviarMenuAluno();
    }

    // Excluir estudante
    public static void excluirEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja excluir: ");
        String matriculaEstudante = scanner.nextLine();

        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        if (estudanteAlvo != null) {
            Estudante.estudantes.remove(estudanteAlvo);
            System.out.println("O estudante foi excluído com sucesso.");
        } else {
            System.out.println("Estudante não encontrado.");
        }

        EstudanteView.enviarMenuAluno();
    }
}


