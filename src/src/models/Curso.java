package models;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nomeCurso;        // Nome do curso
    private int cargaHoraria;        // Carga horária do curso
    private Professor professor;     // Professor associado ao curso
    private static List<Curso> cursos = new ArrayList<>(); // Lista estática de cursos

    // **Construtor**
    public Curso(String nomeCurso, int cargaHoraria, Professor professor) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    // **Getters e Setters** (acessores e modificadores para os atributos)
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

    // **Métodos estáticos de busca e exclusão de cursos**

    // Busca um curso pelo nome
    public static Curso buscarCursoPorNome(String nomeCurso) {
        if (nomeCurso == null || nomeCurso.isEmpty()) {
            System.out.println("Erro: Nome do curso não pode estar vazio.");
            return null;
        }
        return cursos.stream()
                .filter(curso -> curso.getNomeCurso().equalsIgnoreCase(nomeCurso))
                .findFirst()
                .orElse(null);
    }
    public static Curso buscarCursoPorProfessor(String nomeProfessor) {
        return cursos.stream()
                .filter(curso -> curso.getProfessor().getNome().equalsIgnoreCase(nomeProfessor))
                .findFirst()
                .orElse(null);
    }
    // Exclui um curso pelo nome
    public static boolean excluirCursoPorNome(String nomeCurso) {
        Curso curso = buscarCursoPorNome(nomeCurso);
        if (curso != null) {
            cursos.remove(curso);
            System.out.println("Curso '" + nomeCurso + "' foi excluído com sucesso.");
            return true;
        }
        System.out.println("Erro: Curso com o nome '" + nomeCurso + "' não foi encontrado.");
        return false;
    }
}
