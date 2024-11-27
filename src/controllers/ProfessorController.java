package src.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Aluno;
import src.models.Professor;
import src.models.Curso;

public class controller {
    private List<Aluno> alunos;
    private List<Professor> professors;
    private List<Curso> cursos;

    public controller() {
        alunos = new ArrayList<>();
        professors = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void cadastrarAluno(String nome, int idade, String matricula) {
        alunos.add(new Aluno(nome, idade, matricula));
    }

    public void cadastrarProfessor(String nome, int idade, String especialidade) {
        professors.add(new Professor(nome, idade, especialidade));
    }

    public void cadastrarCurso(String nomeCurso, int cargaHoraria, Professor professor) {
        cursos.add(new Curso(nomeCurso, cargaHoraria, professor));
    }

    public void gerarRelatorioAluno() {
        for (Aluno aluno : alunos) {
            aluno.exibirDados();
        }
    }

    public void gerarRelatorioProfessor() {
        for (Professor professor : professors) {
            professor.exibirDados();
        }
    }
}
