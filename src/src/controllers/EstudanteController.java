package controllers;

import models.Estudante;
import views.EstudanteView;
import views.Utilidades;

import java.util.Scanner;

public class EstudanteController {

    // Objeto Scanner compartilhado para capturar entrada do usuário
    private static final Scanner scanner = new Scanner(System.in);

    // **Função para cadastrar um estudante**
    public static void cadastrarEstudante() {
        String nomeDoEstudante; // Nome do estudante
        String matricula; // Matrícula do estudante
        int idade; // Idade do estudante

        // Limpa mensagens na tela
        Utilidades.limparMensagens();
        System.out.println("Digite o nome do estudante: ");
        nomeDoEstudante = scanner.nextLine(); // Captura o nome do estudante

        // Validação da idade: deve ser maior que 0 e menor que 130
        do {
            Utilidades.limparMensagens();
            System.out.println("Digite a idade do estudante (maior que 0 e menor que 130): ");
            idade = scanner.nextInt();
        } while (idade <= 0 || idade > 130);

        scanner.nextLine(); // Consumir a quebra de linha pendente após nextInt()

        // Validação da matrícula: deve conter apenas números
        do {
            System.out.println("\nDigite a matrícula do estudante (apenas números): ");
            matricula = scanner.nextLine();

            if (!matricula.matches("\\d+")) { // Verifica se contém apenas dígitos
                System.out.println("Matrícula inválida. Certifique-se de digitar apenas números.");
            }
        } while (!matricula.matches("\\d+"));

        // Adiciona o estudante à lista global de estudantes
        Estudante.estudantes.add(new Estudante(nomeDoEstudante.trim(), idade, matricula.trim()));

        // Confirmação de cadastro
        Utilidades.limparMensagens();
        System.out.println("O estudante " + nomeDoEstudante.trim() + " foi cadastrado com sucesso!");
        EstudanteView.enviarMenuAluno(); // Retorna ao menu principal
    }

    // **Função para consultar um estudante**
    public static void consultarEstudante() {
        String matriculaEstudante; // Matrícula a ser buscada
        Estudante estudanteAlvo = null; // Estudante encontrado (se existir)

        // Solicita matrícula válida (apenas números)
        do {
            System.out.println("Digite a matrícula do estudante (apenas números): ");
            matriculaEstudante = scanner.nextLine();

            if (!matriculaEstudante.matches("\\d+")) { // Validação de entrada
                System.out.println("Matrícula inválida. Certifique-se de digitar apenas números.");
            }
        } while (!matriculaEstudante.matches("\\d+"));

        // Busca o estudante pela matrícula
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Para a busca ao encontrar o estudante
            }
        }

        // Exibe os dados ou mensagem de erro
        if (estudanteAlvo != null) {
            estudanteAlvo.exibirDados(); // Exibe informações do estudante encontrado
        } else {
            System.out.println("Estudante não encontrado.");
        }

        // Pausa antes de voltar ao menu
        System.out.println("Pressione Enter para voltar ao menu...");
        scanner.nextLine(); // Aguarda entrada do usuário
        EstudanteView.enviarMenuAluno(); // Retorna ao menu principal
    }

    // **Função para editar informações de um estudante**
    public static void editarEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja editar: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula para identificar o estudante

        Estudante estudanteAlvo = null; // Estudante encontrado (se existir)
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Sai do loop ao encontrar o estudante
            }
        }

        if (estudanteAlvo == null) { // Verifica se o estudante foi encontrado
            System.out.println("Estudante não encontrado.");
            EstudanteView.enviarMenuAluno(); // Volta ao menu principal
            return; // Encerra a função
        }

        // Solicita novas informações e atualiza os dados
        System.out.println("Digite o novo nome (atualmente: " + estudanteAlvo.getNome() + "): ");
        estudanteAlvo.setNome(scanner.nextLine().trim());

        System.out.println("Digite a nova idade (atualmente: " + estudanteAlvo.getIdade() + "): ");
        estudanteAlvo.setIdade(Integer.parseInt(scanner.nextLine()));

        System.out.println("Digite a nova matrícula (atualmente: " + estudanteAlvo.getMatricula() + "): ");
        estudanteAlvo.setMatricula(scanner.nextLine().trim());

        // Confirmação de atualização
        System.out.println("As informações do estudante foram atualizadas com sucesso!");
        EstudanteView.enviarMenuAluno(); // Retorna ao menu principal
    }

    // **Função para excluir um estudante**
    public static void excluirEstudante() {
        System.out.println("Digite a matrícula do estudante que deseja excluir: ");
        String matriculaEstudante = scanner.nextLine(); // Lê a matrícula para exclusão

        Estudante estudanteAlvo = null; // Estudante encontrado (se existir)
        for (Estudante estudante : Estudante.estudantes) {
            if (estudante.getMatricula().equals(matriculaEstudante)) {
                estudanteAlvo = estudante;
                break; // Sai do loop ao encontrar o estudante
            }
        }

        if (estudanteAlvo != null) { // Verifica se o estudante foi encontrado
            Estudante.estudantes.remove(estudanteAlvo); // Remove o estudante
            System.out.println("O estudante foi excluído com sucesso.");
        } else {
            System.out.println("Estudante não encontrado."); // Mensagem de erro
        }

        EstudanteView.enviarMenuAluno(); // Retorna ao menu principal
    }
}