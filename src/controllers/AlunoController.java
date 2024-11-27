package src.controllers;

import src.models.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public AlunoController() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);

        String nome;
        int idade;
        String matricula;

        System.out.println("Digite o nome do aluno: ");
        nome = scanner.nextLine();

        System.out.println("Digite a idade do aluno: ");
        idade = scanner.nextInt();

        System.out.println("Digite a matricula do aluno: ");
        matricula = scanner.next();

        scanner.close();

        getAlunos().add(new Aluno(nome.trim(), idade, matricula.trim()));
        System.out.println("Aluno cadastrado com sucesso!\n");
    }

    public void consultarMatriculaAluno() {
        Scanner scanner = new Scanner(System.in);
        String matricula;
        System.out.println("Digite o matricula do aluno: ");
        matricula = scanner.next();

        for (Aluno aluno : getAlunos()) {
            if (aluno == null) {
                System.out.println("Este aluno não foi encontrado.\n");
                return;
            }
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println("Matricula: " + aluno.getMatricula());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                return;
            }
        }
    }

    public Aluno consultarAluno(String matricula) {
        String alunoEncontrado = null;
        for (Aluno aluno : getAlunos()) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoEncontrado = aluno.getNome();
                break;
            }

            if (alunoEncontrado != null) {
                // criar lógica para caso encontrar retornar as informações do aluno
            } else {
                // adicionar mensagem caso nao encontre
            }
        }
        return null;
    }

    public void excluirAluno(String matricula) {
        Aluno aluno = consultarAluno(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno excluído com sucesso!\n");
        } else {
            System.out.println("Aluno não encontrado.\n");
        }
    }

    public void editarAluno(String matricula, String novoNome, int novaIdade) {
        Aluno aluno = consultarAluno(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setIdade(novaIdade);
            System.out.println("Aluno editado com sucesso!\n");
        } else {
            System.out.println("Aluno não encontrado.\n");
        }
    }


    // Menu de alunos:
    public void menuAlunos() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n== MENU ALUNO ==");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Consultar aluno");
            System.out.println("[3] Voltar");
            System.out.print("\nEscolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    String matriculaProcurada;
                    System.out.println("Digite a matricula do aluno: ");
                    matriculaProcurada = scanner.nextLine();
                    consultarAluno(matriculaProcurada);
                    scanner.close();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...\n\n");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        } while (opcao != 3);
    }
}