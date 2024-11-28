package src.Models;

import src.Models.Professor;
import src.Models.Aluno;
import src.View.Main;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private Professor professor;
    private List<Aluno> alunos;

    //construtor
    public Curso(String NomeCurso, int CargaHoraria){
        this.cargaHoraria = CargaHoraria;
        this.nomeCurso = NomeCurso;
        this.alunos = new ArrayList<Aluno>();//cria um arrayList vazio para cada curso criado
    }

    //metodos getters and stters
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

    public void AdicionarAluno(Aluno aluno){
        alunos.add(aluno);//adiciona um aluno la lista
    }

    //Metodos
    public void CadastrarCurso(String NomeCurso, int CargaHoraria, Scanner leitura){}

    public void ConsultarCurso(String NomeCurso, Scanner leitura){}

    public void EditarCurso(String NomeCurso, Scanner leitura){}

    public void ExcluirCurso(String NomeCurso, Scanner leitura){}



    //metodos de limpeza, estruturação e edição
    public Curso encontrarCurso(ArrayList<Aluno> alunos, String NomeCurso){
        Curso Encontrado;

        for(alunos.size()){
            if(NomeCurso == alunos.size()){
                System.out.println("Curso encontrado:\n\nCurso: "+ getNomeCurso() + "\nCarga horária: "+ getCargaHoraria() +"\n");

                Encontrado.nomeCurso = getNomeCurso();
                Encontrado.cargaHoraria = getCargaHoraria();
                Encontrado.professor = getProfessor();
                Encontrado.alunos = getAlunos();

                return Encontrado;
            }
        }
    }

    public...
}
