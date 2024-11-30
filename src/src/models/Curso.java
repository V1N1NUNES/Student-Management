package models;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nomeCurso;  // Armazena o nome do curso.
    private int cargaHoraria;  // Armazena a carga horária total do curso.
    private models.Professor professor;  // Referência ao professor responsável pelo curso.
    private static List<Curso> cursos = new ArrayList<>();  // Lista estática que mantém todos os cursos criados.

    // Construtor de Curso: inicializa o nome, carga horária e professor.
    public Curso(String nomeCurso, int cargaHoraria, Professor professor, List<Estudante> alunos) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    // Getters e Setters para acessar e modificar os atributos do curso.
    public String getNomeCurso() {
        return nomeCurso;  // Retorna o nome do curso.
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;  // Define o nome do curso.
    }

    public int getCargaHoraria() {
        return cargaHoraria;  // Retorna a carga horária do curso.
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;  // Define a carga horária do curso.
    }

    public Professor getProfessor() {
        return professor;  // Retorna o professor do curso.
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;  // Define o professor do curso.
    }

    public static List<Curso> getCursos() {
        return cursos;  // Retorna a lista de todos os cursos.
    }

    public static void setCursos(ArrayList<Curso> cursos) {
        Curso.cursos = cursos;  // Substitui a lista de cursos existente por uma nova lista.
    }

    // Busca um curso pelo nome, ignorando diferenças de maiúsculas/minúsculas.
    // Retorna o curso encontrado ou null se não existir.
    public static Curso buscarCursoPorNome(String nomeCurso) {
        return cursos.stream()
                .filter(curso -> curso.getNomeCurso().equalsIgnoreCase(nomeCurso))
                .findFirst()
                .orElse(null);  // Possível erro: pode retornar null sem tratamento.
    }

    // Exclui um curso pelo nome. Retorna true se o curso for encontrado e removido, false caso contrário.
    public static boolean excluirCursoPorNome(String nomeCurso) {
        Curso curso = buscarCursoPorNome(nomeCurso);
        if (curso != null) {
            cursos.remove(curso);  // Remove o curso encontrado.
            return true;
        }
        return false;  // Retorna false se o curso não for encontrado.
    }

}