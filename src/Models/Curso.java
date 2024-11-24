package src.Models;

abstract public class Curso {
    private String NomeCurso;
    private int CargaHoraria;
    private Professor Ministrante;

    //construtor
    public Curso(String nome, int cargaHoraria, Professor ProfessorCurso){
        this.NomeCurso = nome;
        this.CargaHoraria = cargaHoraria;
        this.Ministrante = ProfessorCurso;
    }

    //metodos getters and setters
    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return Ministrante;
    }

    public void setProfessor(Professor ministrante) {
        Ministrante = ministrante;
    }
}
