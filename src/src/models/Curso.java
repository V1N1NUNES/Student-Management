package models;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private models.Professor professor;
    private static List<Curso> cursos = new ArrayList<>();


    //construtor de cursos
    public Curso(String nomeCurso, int cargaHoraria, Professor professor, List<Estudante> alunos) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
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

    public static List<Curso> getCursos() {
        return cursos;
    }

    public static void setCursos(ArrayList<Curso> cursos) {
        Curso.cursos = cursos;
    }

    public static Curso buscarCursoPorNome(String nomeCurso) {
        return cursos.stream()
                .filter(curso -> curso.getNomeCurso().equalsIgnoreCase(nomeCurso))
                .findFirst()
                .orElse(null);
    }

    public static boolean excluirCursoPorNome(String nomeCurso) {
        Curso curso = buscarCursoPorNome(nomeCurso);
        if (curso != null) {
            cursos.remove(curso);
            return true;
        }
        return false;
    }
}