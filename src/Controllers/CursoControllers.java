package src.Controllers;

import src.View.Main;
import src.Models.Curso;
import src.Models.Professor;
import src.Models.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoControllers{
    private ArrayList<Professor> professores;
    private ArrayList<Curso> cursos;
    private ArrayList<Aluno> alunos;

    //metodos
    public void CadastroCurso(Scanner leitura){
        String NomeCurso;
        int cargaHoraria;

        do{
            System.out.println("Digite o nome do curso: ");
            NomeCurso = leitura.nextLine();

            if(NomeCurso.isEmpty()){
                System.out.println("É necessário um nome para o curso.\n");
                break;
            }
            System.out.println("Digite a carga horária do curso: ");
            cargaHoraria = leitura.nextInt();

            if(cargaHoraria <= 0){
                System.out.println("Digite uma carga horária válida para o curso.\n");
            }
        }while(NomeCurso.isEmpty() || cargaHoraria <= 0 );

        //Adicionar o curso criado na lista de cursos

        System.out.println("Curso cadastrado com sucesso!\n Nome: "+ getNomeCurso() + "\nCarga horaria: "+ Curso.cargaHoraria + "\n");
    }

    public void ConsultarCurso(String NomeCurso, Scanner leitura, ArrayList<Cursos> cursos){
        String nome;

        System.out.println("Digite o nome do curso que deseja consultar: ");
        nome = leitura.nextLine();

        for(Curso curso : Main.cursos){
            boolean encontrado = true;

            if(curso.getNomecurso().equals(nomeCurso) && encontrado){
                System.out.println("Curso: "+ getNomeCurso() + "\nCarga horária: "+ getCargaHoraria() + "\n");
            }else{
                System.out.println("Curso não encontrado.Voltando ao Menu..\n");
                MenuPrincipal();
            }
        }
        System.out.println("Curso não encontrado.Voltando ao Menu..\n");
        MenuPrincipal();
    }

    public void EditarCurso(String NomeCurso, Scanner leitura){
        int opcao;
        System.out.println("1- Adicionar aluno\n2- Remover aluno\n3- Adicionar professor\n4- Remover professor\n5- Voltar\n");
        opcao = leitura.nextInt();

        switch(opcao){
            case 1:
                //Adicionar aluno
                break;
            case 2:
                //remover aluno de um curso
                break;
            case 3:
                //Adicionar professor á um curso
                break;
            case 4:
                //Remover professor de um curso (sem deixar que o curso fique sem professor)
                break;
            case 5:
                MenuPrincipal();
                break;
        }
    }

    public void ExcluirCurso(String NomeCurso, Scanner leitura){
        //implementar função
    }

    public void MenuCurso(Scanner leitura){
        int opcao;

        System.out.println("Menu de Cursos\n\n");
        System.out.printf("1- Cadastrar novo curso\n2- Consultar curso\n3- Matricular estudante\n4- Cadastrar professor\n5- Voltar ao Menu Principal\n");
        opcao = leitura.nextInt();

        switch(opcao){
            case 1:
                //Cadastrar um novo curso
                break;
            case 2:
                //Consultar um curso ja criado
                break;
            case 3:
                //Matricular  estudante
                break;
            case 4:
                //Cadastrar um professor
                break;
            case 5:
                menuPrincipal();//chama o menu principal
                break;
        }
    }
}
