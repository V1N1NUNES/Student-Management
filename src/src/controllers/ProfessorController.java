package controllers;

import models.Professor;
import views.Utilidades;
import java.util.Scanner;

public class ProfessorController {
    private static final Scanner scanner = new Scanner(System.in);

    // Função para cadastrar um professor
    public static void cadastrarProfessor() {
        String nomeProfessor;
        int idade;
        String especialidade;

        // Pedir nome do professor
        Utilidades.limparMensagens();
        System.out.println("Digite o nome do professor: ");
        nomeProfessor = scanner.nextLine();

        // Pedir idade do professor
        do {
            Utilidades.limparMensagens();
            System.out.println("Digite a idade do professor (maior que 0 e menor que 130): ");
            idade = scanner.nextInt();
        } while (idade <= 0 || idade > 130);

        // Pedir especialidade
        Utilidades.limparMensagens();
        System.out.println("Digite a especialidade do professor: ");
        scanner.nextLine();  // Limpar o buffer do scanner
        especialidade = scanner.nextLine();

        // Criar o objeto professor e adicionar à lista
        Professor professor = new Professor(nomeProfessor.trim(), idade, especialidade.trim());
        Professor.addProfessor(professor);

        Utilidades.limparMensagens();
        System.out.println("O professor " + nomeProfessor.trim() + " foi cadastrado com sucesso!");
    }

    // Função para editar um professor
    public static void editarProfessor() {
        System.out.println("Digite o nome do professor que deseja editar: ");
        String nomeProfessor = scanner.nextLine();
        
        Professor professorAlvo = null;

        // Procurar o professor pela lista
        for (Professor professor : Professor.getProfessores()) {
            if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                professorAlvo = professor;
                break;
            }
        }

        if (professorAlvo != null) {
            int opcao;
            do {
                // Exibir opções para o professor encontrado
                System.out.println("Opções para o professor " + professorAlvo.getNome() + ":");
                System.out.println("1. Editar nome");
                System.out.println("2. Editar idade");
                System.out.println("3. Editar especialidade");
                System.out.println("4. Voltar ao menu");

                opcao = scanner.nextInt();

                // Menu de edição
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o novo nome do professor: ");
                        scanner.nextLine();  // Limpar o buffer
                        professorAlvo.setNome(scanner.nextLine());
                        System.out.println("Nome atualizado com sucesso!");
                        break;
                    case 2:
                        System.out.println("Digite a nova idade do professor: ");
                        professorAlvo.setIdade(scanner.nextInt());
                        System.out.println("Idade atualizada com sucesso!");
                        break;
                    case 3:
                        System.out.println("Digite a nova especialidade do professor: ");
                        scanner.nextLine();  // Limpar o buffer
                        professorAlvo.setEspecialidade(scanner.nextLine());
                        System.out.println("Especialidade atualizada com sucesso!");
                        break;
                    case 4:
                        System.out.println("Voltando ao menu...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } while (opcao != 4); // Continuar até o usuário escolher voltar
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    // Função para excluir um professor
    public static void excluirProfessor() {
        System.out.println("Digite o nome do professor que deseja excluir: ");
        String nomeProfessor = scanner.nextLine();

        Professor professorAlvo = null;

        // Procurar o professor pela lista
        for (Professor professor : Professor.getProfessores()) {
            if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                professorAlvo = professor;
                break;
            }
        }

        if (professorAlvo != null) {
            // Remover o professor da lista
            Professor.removeProfessor(professorAlvo);
            System.out.println("O professor " + nomeProfessor + " foi excluído com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }
}

