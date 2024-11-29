package controllers;

import models.Estudante;
import views.EstudanteView;

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

    public static void relatorioDeProfessores(){
        //implementar relatório
    }
}
