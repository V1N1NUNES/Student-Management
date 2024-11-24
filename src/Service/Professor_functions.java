package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Professor;

public class Professor_functions {
    private static final List<Professor> professores = new ArrayList<>();

    public static void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira aqui o nome do professor:");
        String nome = scanner.nextLine();

        System.out.println("Insira aqui a idade do professor:");
        int idade;
        while (true) {
            try {
                idade = Integer.parseInt(scanner.nextLine());
                if (idade < 18 || idade > 100) {
                    System.out.println("Idade inválida! O professor deve ter entre 18 e 100 anos. Tente novamente:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira uma idade válida (número).");
            }
        }

        System.out.println("Insira aqui a especialidade do professor:");
        String especialidade = scanner.nextLine();

        System.out.println("Insira aqui o CPF do professor (11 dígitos):");
        String cpf;
        while (true) {
            cpf = scanner.nextLine();
            if (cpf.matches("\\d{11}") && !existeCpf(cpf)) {
                break;
            } else if (existeCpf(cpf)) {
                System.out.println("Esse CPF já está cadastrado. Tente novamente:");
            } else{
                System.out.println("CPF inválido! Deve conter exatamente 11 dígitos numéricos. Tente novamente:");
            }

        }

        Professor novoProfessor = new Professor(nome, idade, especialidade, cpf);
        professores.add(novoProfessor);
        System.out.println("Cadastro realizado com sucesso!");
    }

//Verificador de CPF: To pensando em criar uma pagina só para verificadores (sujestão pra equipe ai)
    private static boolean existeCpf(String cpf) {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados!");
        } else {
            System.out.println("Lista de professores:");
            for (Professor professor : professores) {
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Idade: " + professor.getIdade());
                System.out.println("Especialidade: " + professor.getEspecialidade());
                System.out.println("CPF: " + professor.getCpf());
                System.out.println("-----------------------------");
            }
        }
    }

    public static void consultarProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do professor que desejas procurar:");
        String cpf = scanner.nextLine();

        boolean encontrado = false;

        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                System.out.println("Professor encontrado!");
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Idade: " + professor.getIdade());
                System.out.println("Especialidade: " + professor.getEspecialidade());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("O professor não está cadastrado.");
        }
        System.out.println("Desejas realizar alguma das seguintes ações (Digite 0 para sair): \n1- Editar professor \n 2-Excluir Professor");
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                editarProfessor(cpf);
                break;

            case 2:
                excluirProfessor(cpf);
                break;
        }
    }

    public static void excluirProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do professor que desejas excluir:");
        String cpf = scanner.nextLine();

        boolean encontrado = false;

        var iterator = professores.iterator();
        while (iterator.hasNext()) {
            var professor = iterator.next();
            if (professor.getCpf().equals(cpf)) {
                iterator.remove();
                System.out.println("Professor excluído com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado!");
        }
    }

    public static void excluirProfessor(String cpf) {

        boolean encontrado = false;

        var iterator = professores.iterator();
        while (iterator.hasNext()) {
            var professor = iterator.next();
            if (professor.getCpf().equals(cpf)) {
                iterator.remove();
                System.out.println("Professor excluído com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado!");
        }
    }
    public static void editarProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do professor que desejas editar:");
        String cpf = scanner.nextLine();

        boolean encontrado = false;

        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                encontrado = true;

                int opcao;
                do {
                    System.out.println("\nProfessor encontrado: " + professor.getNome());
                    System.out.println("Selecione a informação que deseja modificar:");
                    System.out.println("1. Nome");
                    System.out.println("2. Idade");
                    System.out.println("3. Especialidade");
                    System.out.println("4. Sair");
                    System.out.print("Opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha pendente

                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            professor.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                            break;

                        case 2:
                            System.out.print("Digite a nova idade: ");
                            int novaIdade;
                            while (true) {
                                try {
                                    novaIdade = Integer.parseInt(scanner.nextLine());
                                    if (novaIdade < 18 || novaIdade > 100) {
                                        System.out.println("Idade inválida! Tente novamente:");
                                    } else {
                                        professor.setIdade(novaIdade);
                                        System.out.println("Idade atualizada com sucesso!");
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Por favor, insira uma idade válida.");
                                }
                            }
                            break;

                        case 3:
                            System.out.print("Digite a nova especialidade: ");
                            String novaEspecialidade = scanner.nextLine();
                            professor.setEspecialidade(novaEspecialidade);
                            System.out.println("Especialidade atualizada com sucesso!");
                            break;

                        case 4:
                            System.out.println("Encerrando a modificação.");
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (opcao != 4);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado.");
        }
    }
/*
Tem duas funções de editarProfessor pois uma recebe um paramêtro e outra não.

A que não recebe um paramêtro tem a funçao de pedir o CPF pro usuario. A que recebe, não tem a função de pedir o CPF.
 */
    public static void editarProfessor(String cpf) {
        Scanner scanner = new Scanner(System.in);


        boolean encontrado = false;

        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                encontrado = true;

                int opcao;
                do {
                    System.out.println("\nProfessor encontrado: " + professor.getNome());
                    System.out.println("Selecione a informação que deseja modificar:");
                    System.out.println("1. Nome");
                    System.out.println("2. Idade");
                    System.out.println("3. Especialidade");
                    System.out.println("4. Sair");
                    System.out.print("Opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha pendente

                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            professor.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                            break;

                        case 2:
                            System.out.print("Digite a nova idade: ");
                            int novaIdade;
                            while (true) {
                                try {
                                    novaIdade = Integer.parseInt(scanner.nextLine());
                                    if (novaIdade < 18 || novaIdade > 100) {
                                        System.out.println("Idade inválida! Tente novamente:");
                                    } else {
                                        professor.setIdade(novaIdade);
                                        System.out.println("Idade atualizada com sucesso!");
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Por favor, insira uma idade válida.");
                                }
                            }
                            break;

                        case 3:
                            System.out.print("Digite a nova especialidade: ");
                            String novaEspecialidade = scanner.nextLine();
                            professor.setEspecialidade(novaEspecialidade);
                            System.out.println("Especialidade atualizada com sucesso!");
                            break;

                        case 4:
                            System.out.println("Encerrando a modificação.");
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (opcao != 4);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado.");
        }
    }
}
