package controllers;

import models.Professor;
import views.CursoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorController {
    private static final List<Professor> professores = new ArrayList<>();

    public static boolean procurarProfessor(String nomeProfessor) {
        return professores.stream().anyMatch(prof -> prof.getNome().equalsIgnoreCase(nomeProfessor));
    }

    public static Professor buscarProfessorPorNome(String nomeProfessor) {
        return professores.stream()
                .filter(prof -> prof.getNome().equalsIgnoreCase(nomeProfessor))
                .findFirst()
                .orElse(null);
    }

    public static void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);

        String nome;
        while (true) {
            System.out.println("Insira o nome do professor:");
            nome = scanner.nextLine();
            String erro = validarNome(nome);
            if (erro == null) {
                break;
            } else {
                System.out.println("Erro: " + erro);
            }
        }

        int idade;
        while (true) {
            System.out.println("Insira a idade do professor (18-100):");
            try {
                idade = Integer.parseInt(scanner.nextLine());
                String erro = validarIdade(idade);
                if (erro == null) {
                    break;
                } else {
                    System.out.println("Erro: " + erro);
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um número válido para a idade.");
            }
        }

        String especialidade;
        while (true) {
            System.out.println("Insira a especialidade do professor:");
            especialidade = scanner.nextLine();
            String erro = validarEspecialidade(especialidade);
            if (erro == null) {
                break;
            } else {
                System.out.println("Erro: " + erro);
            }
        }

        Professor novoProfessor = new Professor(nome, idade, especialidade);
        professores.add(novoProfessor);

        System.out.println("Professor cadastrado com sucesso!");
        System.out.println("Voltando para o menu de cursos.");
        CursoView.enviarMenuCurso();
    }

    public static void editarProfessor(String nomeProfessor) {
        Professor professor = buscarProfessorPorNome(nomeProfessor);

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nProfessor encontrado: " + professor.getNome());
            System.out.println("[1] Alterar Nome");
            System.out.println("[2] Alterar Idade");
            System.out.println("[3] Alterar Especialidade");
            System.out.println("[4] Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha pendente

            switch (opcao) {
                case 1:
                    String novoNome;
                    while (true) {
                        System.out.print("Digite o novo nome: ");
                        novoNome = scanner.nextLine();
                        String erro = validarNome(novoNome);
                        if (erro == null) {
                            professor.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                            break;
                        } else {
                            System.out.println("Erro: " + erro);
                        }
                    }
                    break;

                case 2:
                    int novaIdade;
                    while (true) {
                        System.out.print("Digite a nova idade: ");
                        try {
                            novaIdade = Integer.parseInt(scanner.nextLine());
                            String erro = validarIdade(novaIdade);
                            if (erro == null) {
                                professor.setIdade(novaIdade);
                                System.out.println("Idade atualizada com sucesso!");
                                break;
                            } else {
                                System.out.println("Erro: " + erro);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: Por favor, insira um número válido para a idade.");
                        }
                    }
                    break;

                case 3:
                    String novaEspecialidade;
                    while (true) {
                        System.out.print("Digite a nova especialidade: ");
                        novaEspecialidade = scanner.nextLine();
                        String erro = validarEspecialidade(novaEspecialidade);
                        if (erro == null) {
                            professor.setEspecialidade(novaEspecialidade);
                            System.out.println("Especialidade atualizada com sucesso!");
                            break;
                        } else {
                            System.out.println("Erro: " + erro);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Edição encerrada.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    public static void excluirProfessor(String nomeProfessor) {
        Professor professor = buscarProfessorPorNome(nomeProfessor);
        if (professor != null) {
            professores.remove(professor);
            System.out.println("Professor removido com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public static String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "O nome não pode ser vazio.";
        }
        if (nome.length() < 3 || nome.length() > 100) {
            return "O nome deve ter entre 3 e 100 caracteres.";
        }
        if (!nome.matches("[a-zA-Z ]+")) {
            return "O nome deve conter apenas letras e espaços.";
        }
        return null; // Retorna null se não houver erros
    }

    public static String validarIdade(int idade) {
        if (idade < 18 || idade > 100) {
            return "A idade deve estar entre 18 e 100 anos.";
        }
        return null;
    }

    public static String validarEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.trim().isEmpty()) {
            return "A especialidade não pode ser vazia.";
        }
        if (especialidade.length() < 3 || especialidade.length() > 50) {
            return "A especialidade deve ter entre 3 e 50 caracteres.";
        }
        return null;
    }
}
