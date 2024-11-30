package controllers;

import models.Estudante;
import views.EstudanteView;
import views.Utilidades;

import java.util.Scanner;

public class EstudanteController {

    // Objeto Scanner para capturar entrada do usuário
    private static final Scanner scanner = new Scanner(System.in);

    // **Função para cadastrar um estudante**
    public static void cadastrarEstudante() {
        String nomeDoEstudante; // Armazena o nome do estudante
        String matricula;       // Armazena a matrícula do estudante
        int idade;              // Armazena a idade do estudante

        // Limpa mensagens anteriores e solicita o nome do estudante
        Utilidades.limparMensagens();
        System.out.println("Digite o nome do estudante: ");
        nomeDoEstudante = scanner.nextLine(); // Lê o nome do estudante

        // Valida a idade do estudante para que esteja entre 1 e 130 anos
        do {
            System.out.println("Digite a idade do estudante (maior que 0 e menor que 130): ");
            idade = Integer.parseInt(scanner.nextLine()); // Lê a idade como string e converte para inteiro
        } while (idade <= 0 || idade > 130); // Repetir enquanto a idade for inválida

        // Solicita a matrícula do estudante
        System.out.println("Digite a matrícula do estudante: ");
        matricula = scanner.nextLine(); // Lê a matrícula

        // **Verifica se a matrícula já existe na lista**
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matricula)) {
                // Exibe mensagem de erro se a matrícula já estiver cadastrada
                System.out.println("Já existe um estudante com essa matrícula.");
                EstudanteView.enviarMenuAluno(); // Volta ao menu do estudante
                return; // Sai da função
            }
        }

        // Adiciona um novo estudante à lista
        Estudante.estudantes.add(new Estudante(nomeDoEstudante.trim(), idade, matricula.trim()));
        System.out.println("O estudante " + nomeDoEstudante + " foi cadastrado com sucesso!");

        // Volta ao menu do estudante após o cadastro
        EstudanteView.enviarMenuAluno();
    }  //error (verificação de matricula)

    // **Função para consultar um estudante**
    public static void consultarEstudante() {
        System.out.println("Digite a matrícula do estudante: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula do estudante para consulta

        // Procura o estudante na lista com base na matrícula
        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Sai do loop quando encontra o estudante
            }
        }

        // Exibe as informações do estudante ou uma mensagem de erro
        if (estudanteAlvo != null) {
            estudanteAlvo.exibirDados(); // Exibe os dados do estudante
        } else {
            System.out.println("Estudante não encontrado.");
        }

        // Pausa para que o usuário leia as informações antes de voltar ao menu
        System.out.println("Pressione Enter para voltar ao menu...");
        scanner.nextLine(); // Aguarda o pressionamento de Enter
        EstudanteView.enviarMenuAluno(); // Volta ao menu do estudante
    }

    // **Função para editar informações de um estudante**
    public static void editarEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja editar: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula do estudante para edição

        // Procura o estudante na lista
        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Sai do loop quando encontra o estudante
            }
        }

        // Verifica se o estudante foi encontrado
        if (estudanteAlvo == null) {
            System.out.println("Estudante não encontrado.");
            EstudanteView.enviarMenuAluno(); // Volta ao menu do estudante
            return; // Sai da função
        }

        // Solicita novas informações para atualizar o estudante
        System.out.println("Digite o novo nome (atualmente: " + estudanteAlvo.getNome() + "): ");
        estudanteAlvo.setNome(scanner.nextLine().trim()); // Atualiza o nome

        System.out.println("Digite a nova idade (atualmente: " + estudanteAlvo.getIdade() + "): ");
        estudanteAlvo.setIdade(Integer.parseInt(scanner.nextLine())); // Atualiza a idade

        System.out.println("Digite a nova matrícula (atualmente: " + estudanteAlvo.getMatricula() + "): ");
        estudanteAlvo.setMatricula(scanner.nextLine().trim()); // Atualiza a matrícula

        // Exibe mensagem de sucesso
        System.out.println("As informações do estudante foram atualizadas com sucesso!");

        // Volta ao menu do estudante após a edição
        EstudanteView.enviarMenuAluno();
    }

    // **Função para excluir um estudante**
    public static void excluirEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja excluir: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula do estudante para exclusão

        // Procura o estudante na lista
        Estudante estudanteAlvo = null;
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Sai do loop quando encontra o estudante
            }
        }

        // Verifica se o estudante foi encontrado
        if (estudanteAlvo != null) {
            // Remove o estudante da lista
            Estudante.estudantes.remove(estudanteAlvo);
            System.out.println("O estudante foi excluído com sucesso.");
        } else {
            System.out.println("Estudante não encontrado.");
        }

        // Volta ao menu do estudante após a exclusão
        EstudanteView.enviarMenuAluno();
    }
}

