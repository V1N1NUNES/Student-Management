package controllers;

import models.Curso;
import models.Estudante;
import models.Professor;
import views.CursoView;
import views.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoController {
    //metodos
    public static void cadastrarCurso(){
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        int cargaHoraria;
        Professor ministrante;
        String NomeMinistrante;
        boolean  validacao = false;
        ArrayList<Estudante> turma;

        do {
            System.out.println("Digite o nome do curso: ");
            nomeCurso = leitura.nextLine();

            if (nomeCurso.isEmpty()) {
                System.out.println("É necessário um nome para o curso.\n");
                continue;
            }

            System.out.println("Digite a carga horária do curso: ");
            cargaHoraria = leitura.nextInt();
            leitura.nextLine();

            if (cargaHoraria <= 0) {
                System.out.println("Digite uma carga horária válida para o curso.\n");
            }

        /*

        */
            turma = new ArrayList<Estudante>();
            Curso NovoCurso = new Curso(nomeCurso, cargaHoraria, ministrante,turma);
            validacao = true;

        } while (validacao);
        leitura.close();

        System.out.println("Voltando ao Menu de cursos...\n");
        Main.enviarMenu();
    }

    public static void consultarCurso(){
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        boolean cursoEncontrado = false;

        System.out.println("Digite o nome do curso que deseja consultar: ");
        nomeCurso = leitura.nextLine();

        //procurar na lista o nome do curso
        //se estiver errado, voltar ao menu
        //se não, mostrar o curso encontrado

        leitura.close();
    }

    public static void editarCurso(){
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        boolean encontrado = true;

        System.out.println("Digite o nome do curso que deseja editar: ");
        nomeCurso = leitura.nextLine();

        //Procurar o curso na lista de cursos

        //Se encontrado = Menu de edição de cursos
        if(encontrado){
            CursoView.menuEdicao();
        }else{
            System.out.println("Curso "+ nomeCurso + "Não encontrado.\n");
            CursoView.enviarMenuCurso();
        }
        leitura.close();
    }

    public static void excluirCurso(){
        Scanner leitura = new Scanner(System.in);
        
    }

    //mmetodos de edição
    public static void alterarNome(){
        //implementar
    }public static void alterarCargaHoraria(){
        //implementar
    }public static void alterarProfessor(){
        //implementar
    }
}
