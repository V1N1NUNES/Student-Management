package src.Service;

import src.Models.Aluno;
import src.Models.Curso;
import src.Models.Professor;
import java.util.ArrayList;
import java.util.Scanner;

public class CursosService extends Curso {
    ArrayList<Curso> cursos;  //ArrayList para armazenar todos os cursos cadastrados
    ArrayList<Professor> professores;  //ArrayList para armazenar todos os professores ministrantes no cursos criados
    ArrayList<Aluno> alunos;  //ArrayList para armazenar os alunos cadastrados nos cursos

    //construtor da classe abstrata "Curso"
    public CursosService(String nome, int cargaHoraria, Professor ProfessorCurso) {
        super(nome, cargaHoraria, ProfessorCurso);
    }


    //getters and setters
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }


    //metodos e funcionalidades
    private void ListarCursos(ArrayList<Curso> cursos){
        System.out.println("Cursos cadastros:\n");
        for(Curso curso : cursos){
            System.out.println("Nome: " + curso.getNomeCurso() + ", Carga Horária: " + curso.getCargaHoraria() +
                    ", Professor: " + curso.getProfessor());
        }
    } //Lista todos os cursos

    public void consultarCurso(ArrayList<Curso> cursos, Scanner leitura){
        String NomeCurso;

    } //Mostra um curso especifico

    public void cadastrarCurso(String nome, int cargaHoraria, Scanner leitura, Professor ministrante){
        //cria um curso
    } //cadastra um novo curso

    public void editarCurso(ArrayList<Curso> cursos){

    } //edita um curso ja existente

    public void excluirCurso(String NomeCurso, ArrayList<Curso> cursos){

    } //exclui um curso ja existente

    public void AdicionarAluno(ArrayList<Curso> cursos){

    } //Adiciona um aluno em um curso ja existente


    //metodos de suporte, limpeza e pesquisa


}
