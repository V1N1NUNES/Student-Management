package controllers;

import models.Curso;
import models.Professor;
import views.CursoView;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoController {

    public static void cadastrarCurso() {
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        int cargaHoraria;
        Professor ministrante = null;

        System.out.println("Digite o nome do curso: ");
        nomeCurso = leitura.nextLine().trim();

        if (nomeCurso.isEmpty()) {
            System.out.println("Erro: Nome do curso não pode estar vazio.");
            return;
        }

        System.out.println("Digite a carga horária do curso: ");
        cargaHoraria = leitura.nextInt();
        leitura.nextLine(); // Consumir quebra de linha

        if (cargaHoraria <= 0) {
            System.out.println("Erro: A carga horária deve ser maior que zero.");
            return;
        }

        System.out.println("Digite o nome do professor ministrante: ");
        String nomeProfessor = leitura.nextLine().trim();

        ministrante = ProfessorController.buscarProfessorPorNome(nomeProfessor);

        if (ministrante == null) {
            System.out.println("Erro: Professor não encontrado. Cadastrar professor antes de continuar.");
            return;
        }

        Curso novoCurso = new Curso(nomeCurso, cargaHoraria, ministrante);

        if (Curso.getCursos() == null) {
            Curso.setCursos(new ArrayList<>());
        }

        Curso.getCursos().add(novoCurso);
        System.out.println("Curso cadastrado com sucesso: " + nomeCurso);
    }

    public static void consultarCurso() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o nome do curso que deseja consultar: ");
        String nomeCurso = leitura.nextLine().trim();

        Curso curso = Curso.buscarCursoPorNome(nomeCurso);

        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        System.out.println("\n== Detalhes do Curso ==");
        System.out.println("Nome: " + curso.getNomeCurso());
        System.out.println("Carga Horária: " + curso.getCargaHoraria());
        System.out.println("Professor: " + curso.getProfessor().getNome());
    }

    public static void editarCurso() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o nome do curso que deseja editar:");
        String nomeCurso = leitura.nextLine().trim();

        Curso cursoEncontrado = Curso.buscarCursoPorNome(nomeCurso);

        if (cursoEncontrado == null) {
            System.out.println("Curso não encontrado. Verifique o nome digitado.");
            return;
        }

        CursoView.menuEdicao(nomeCurso);
    }

    public static void excluirCurso() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o nome do curso que deseja excluir: ");
        String nomeCurso = leitura.nextLine().trim();

        if (Curso.excluirCursoPorNome(nomeCurso)) {
            System.out.println("Curso excluído com sucesso.");
        } else {
            System.out.println("Erro: Curso não encontrado.");
        }
    }

    public static void alterarNome(String nomeCursoAtual) {
        Scanner leitura = new Scanner(System.in);

        Curso curso = Curso.buscarCursoPorNome(nomeCursoAtual);
        if (curso == null) {
            System.out.println("Erro: Curso não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome para o curso:");
        String novoNome = leitura.nextLine().trim();

        if (novoNome.isEmpty()) {
            System.out.println("Erro: O nome não pode estar vazio.");
            return;
        }

        curso.setNomeCurso(novoNome);
        System.out.println("Nome do curso alterado com sucesso para: " + novoNome);
    }

    public static void alterarCargaHoraria(String nomeCurso) {
        Scanner leitura = new Scanner(System.in);

        Curso curso = Curso.buscarCursoPorNome(nomeCurso);
        if (curso == null) {
            System.out.println("Erro: Curso não encontrado.");
            return;
        }

        System.out.println("Digite a nova carga horária:");
        int novaCH = leitura.nextInt();

        if (novaCH <= 0) {
            System.out.println("Erro: A carga horária deve ser maior que zero.");
            return;
        }

        curso.setCargaHoraria(novaCH);
        System.out.println("Carga horária alterada com sucesso para: " + novaCH);
    }

    public static void alterarProfessor(String nomeCurso) {
        Scanner leitura = new Scanner(System.in);

        Curso curso = Curso.buscarCursoPorNome(nomeCurso);
        if (curso == null) {
            System.out.println("Erro: Curso não encontrado.");
            return;
        }

        System.out.println("Digite o nome do novo professor ministrante:");
        String nomeProfessor = leitura.nextLine().trim();

        Professor novoProfessor = ProfessorController.buscarProfessorPorNome(nomeProfessor);
        if (novoProfessor == null) {
            System.out.println("Erro: Professor não encontrado.");
            return;
        }

        curso.setProfessor(novoProfessor);
        System.out.println("Professor alterado com sucesso para: " + novoProfessor.getNome());
    }
}