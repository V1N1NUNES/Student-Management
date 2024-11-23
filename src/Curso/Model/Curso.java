package src.Classes;

import java.util.List;
import java.util.Scanner;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private Professor professor;
    private List<Estudante> estudantes;

    //construtor de cursos
    public Curso (String NomeCurso, int CargaHoraria, Professor prof){
        this.nomeCurso = NomeCurso;
        this.cargaHoraria = CargaHoraria;
        this.professor = prof;
    }

    //getters and stters
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
    public List<Estudante> getEstudantes() {
        return estudantes;
    }
    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }



    //metodos
    public void adcionarEstudante(Estudante estudante){
        estudantes.add(estudante);
    }

    public void removerEstudante(Estudante estudante){
        estudantes.remove(estudante);
    }

    public void listarEstudantes(){
        System.out.println("Estudantes cursando: "+ nomeCurso + ":");

        for(Estudante estudante: estudantes){
            estudante.consultar();
        }
    }

    public void exibirCurso(){
        System.out.println("Curso: " + nomeCurso + "\nCarga horária: " + cargaHoraria + "Professor: " + professor.getNome() + "(Especialidade: " + professor.getEspecialidade() +")");
        listarEstudantes();
    }


    public void MenuCurso(Scanner leitura){
        int opcao;
        boolean Opcao = true;

        System.out.println("MENU CURSO\n\n1- Editar professor\n2- Editar Alunos\n3- Editar Carga horária\n4- Menu principal\n");
        opcao = leitura.nextInt();

        do{
            switch(opcao){
                case 1:
                    //implementar
                    break;
                case 2:
                    //implementar
                    break;
                case 3:
                    //implementar
                    break;
                case 4:
                    System.out.println("Voltando ao Menu principal...\n\n");
                    //Menu principal
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(Opcao == false);
    }
}
