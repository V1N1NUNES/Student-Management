package models;

import java.util.List;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private models.Professor professor;
    private List<Estudante> alunos;

    //construtor de cursos
    public Curso(String nomeCurso, int cargaHoraria, Professor professor, List<Estudante> alunos) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = Estudante.getEstudantes();
    }


    //Eu devo fazer a importação dos métodos das outras classes?


    //getters and setters
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

    public List<Estudante> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Estudante> alunos) {
        this.alunos = alunos;
    }
}
