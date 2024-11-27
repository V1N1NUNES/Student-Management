package src.controllers;

import src.models.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        aluno.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public Aluno consultarAluno(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void excluirAluno(String matricula) {
        Aluno aluno = consultarAluno(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void editarAluno(String matricula, String novoNome, int novaIdade) {
        Aluno aluno = consultarAluno(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setIdade(novaIdade);
            System.out.println("Aluno editado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }


    // Menu de alunos:
    private void menuAlunos(Scanner sc) {
        int opcao;

        do {
            System.out.println("\n== MENU ALUNO ==");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Consultar aluno");
            System.out.println("[3] Voltar");
            System.out.print("\nEscolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer após nextInt()

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    consultarAluno();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }
}
