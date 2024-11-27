package src.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private Professor professor;
    private List<Aluno> alunos;

    public Curso(String nomeCurso, int cargaHoraria, Professor professor) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void exibirDados() {
        System.out.println("Nome: " + nomeCurso);
        System.out.println("Carga Horaria: " + cargaHoraria);
        System.out.println("Professor: " + professor);
        System.out.println("Alunos: ");
        for (Aluno aluno : alunos) {
            aluno.exibirDados();
        }
    }
}
