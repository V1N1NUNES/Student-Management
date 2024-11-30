package controllers;

import models.Estudante;
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

    /*
    public static void relatorioDeProfessores(){
        Scanner scanner = new Scanner(System.in);

        if (Professor.professores.isEmpty()) {
            System.out.println("Nenhum professor foi cadastrado.");
            System.out.println("Pressione ENTER ou RETURN para retornar ao menu...");
            scanner.nextLine();
            ProfessorView.enviarMenuProfessor();
            return;
        }

        System.out.println("Listando todos os professores cadastrados: ");
        for (Professor professores: Professor.professores) {
            System.out.println("Nome: " + professores.getNome() + " - Matrícula: " + professores.getMatricula());
        }

        System.out.println("Pressione ENTER ou RETURN para retornar ao menu...");
        scanner.nextLine();
        EstudanteView.enviarMenuAluno();
    }
                //implementar direito o relatório de professores
     */
}

