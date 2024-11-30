package controllers;

import models.Curso;
import models.Estudante;
import models.Professor;
import views.EstudanteView;
import views.ProfessorView;

import java.util.Scanner;

public class RelatorioController {
    public static void relatorioDeEstudantes() {
        Scanner scanner = new Scanner(System.in);
        if (Estudante.estudantes.isEmpty()) {
            System.out.println("Nenhum estudante foi cadastrado.");
            System.out.println("Pressione ENTER ou RETURN para retornar ao menu...");
            scanner.nextLine();
            EstudanteView.enviarMenuAluno();

            return;
        }

        System.out.println("Listando todos os alunos cadastrados: ");
        for (Estudante estudante : Estudante.estudantes) {
            System.out.println("Nome: " + estudante.getNome() + " - Matrícula: " + estudante.getMatricula());
        }

        System.out.println("Pressione ENTER ou RETURN para retornar ao menu...");
        scanner.nextLine();
        EstudanteView.enviarMenuAluno();
    }

    public static void relatorioProfessor() {
        Scanner scanner = new Scanner(System.in);

        // Verifica se há professores cadastrados
        if (ProfessorController.getProfessores().isEmpty()) {
            System.out.println("Nenhum professor foi cadastrado!");
            System.out.println("Pressione ENTER ou RETURN para retornar ao menu...");
            scanner.nextLine();
            ProfessorView.enviarMenuProfessor(); // Retorno ao menu de professores
            return;
        }

        // Lista os professores cadastrados
        System.out.println("Listando todos os professores cadastrados:");
        for (Professor professor : ProfessorController.getProfessores()) {
            // Exibe informações do professor
            System.out.println("Nome Professor: " + professor.getNome());
            System.out.println("Idade do Professor: " + professor.getIdade());
            System.out.println("Especialidade: " + professor.getEspecialidade());

            // Busca o curso associado ao professor
            Curso cursoAssociado = Curso.buscarCursoPorProfessor(professor.getNome());
            if (cursoAssociado != null) {
                System.out.println("Curso Associado: " + cursoAssociado.getNomeCurso());
                System.out.println("Carga Horária do Curso: " + cursoAssociado.getCargaHoraria());
            } else {
                System.out.println("Curso Associado: Nenhum curso atribuído.");
            }

            System.out.println("-----------------------------");
        }

        System.out.println("Pressione ENTER ou RETURN para retornar ao menu...");
        scanner.nextLine();
        ProfessorView.enviarMenuProfessor(); // Retorno ao menu de professores
    }
}

