package controllers;

import models.Estudante;
import views.EstudanteView;

import java.util.Scanner;

public class EstudanteController {

    // Objeto Scanner para capturar entrada do usuário
    private static final Scanner scanner = new Scanner(System.in);

    // Função para cadastrar um estudante
    public static void cadastrarEstudante() {
        String nomeDoEstudante; // Armazena o nome do estudante
        String matricula;       // Armazena a matrícula do estudante
        int idade;              // Armazena a idade do estudante

        // Limpa mensagens anteriores e solicita o nome do estudante
        System.out.println("Digite o nome do estudante: ");
        nomeDoEstudante = scanner.nextLine(); // Lê o nome do estudante

        // Valida a idade do estudante para garantir que esteja entre 1 e 130 anos
        do {
            System.out.println("Digite a idade do estudante (maior que 0 e menor que 130): ");
            idade = Integer.parseInt(scanner.nextLine()); // Converte a idade para inteiro
        } while (idade <= 0 || idade > 130); // Repete até que a idade seja válida

        // Solicita a matrícula do estudante
        System.out.println("Digite a matrícula do estudante: ");
        matricula = scanner.nextLine();

        // Verifica se a matrícula já está cadastrada
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matricula)) {
                System.out.println("Já existe um estudante com essa matrícula.");
                EstudanteView.enviarMenuAluno(); // Retorna ao menu do estudante
                return;
            }
        }

        // Adiciona um novo estudante à lista
        Estudante.estudantes.add(new Estudante(nomeDoEstudante.trim(), idade, matricula.trim()));
        System.out.println("O estudante " + nomeDoEstudante + " foi cadastrado com sucesso!");

        // Retorna ao menu do estudante
        EstudanteView.enviarMenuAluno();
    }

    // Função para consultar um estudante
    public static void consultarEstudante() {
        System.out.println("Digite a matrícula do estudante: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula para consulta

        // Procura o estudante pela matrícula
        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Interrompe a busca ao encontrar
            }
        }

        // Exibe os dados do estudante ou informa que não foi encontrado
        if (estudanteAlvo != null) {
            estudanteAlvo.exibirDados(); // Chama o método para exibir os dados
        } else {
            System.out.println("Estudante não encontrado.");
        }

        // Aguarda o pressionamento de Enter antes de retornar ao menu
        System.out.println("Pressione Enter para voltar ao menu...");
        scanner.nextLine();
        EstudanteView.enviarMenuAluno();
    }

    // Função para editar informações de um estudante
    public static void editarEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja editar: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula

        // Procura o estudante pela matrícula
        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        // Verifica se o estudante foi encontrado
        if (estudanteAlvo == null) {
            System.out.println("Estudante não encontrado.");
            EstudanteView.enviarMenuAluno();
            return;
        }

        // Solicita as novas informações do estudante
        System.out.println("Digite o novo nome (atualmente: " + estudanteAlvo.getNome() + "): ");
        estudanteAlvo.setNome(scanner.nextLine().trim());

        System.out.println("Digite a nova idade (atualmente: " + estudanteAlvo.getIdade() + "): ");
        estudanteAlvo.setIdade(Integer.parseInt(scanner.nextLine()));

        System.out.println("Digite a nova matrícula (atualmente: " + estudanteAlvo.getMatricula() + "): ");
        estudanteAlvo.setMatricula(scanner.nextLine().trim());

        System.out.println("As informações do estudante foram atualizadas com sucesso!");

        // Retorna ao menu do estudante
        EstudanteView.enviarMenuAluno();
    }

    // Função para excluir um estudante
    public static void excluirEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja excluir: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula

        // Procura o estudante pela matrícula
        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        // Verifica se o estudante foi encontrado
        if (estudanteAlvo != null) {
            Estudante.estudantes.remove(estudanteAlvo); // Remove o estudante
            System.out.println("O estudante foi excluído com sucesso.");
        } else {
            System.out.println("Estudante não encontrado.");
        }

        // Retorna ao menu do estudante
        EstudanteView.enviarMenuAluno();
    }
}

