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
    public static void cadastrarCurso() {
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        int cargaHoraria;
        Professor ministrante = null;
        String NomeMinistrante;
        boolean validacao = false;
        boolean encontrado = false;
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
                continue;
            }

            System.out.println("Digite o nome do professor ministrante (já cadastrado): ");
            NomeMinistrante = leitura.nextLine();

            // Verifica se o professor existe
            ministrante = ProfessorController.buscarProfessorPorNome(NomeMinistrante);

            if (ministrante == null) {
                System.out.println("Professor não encontrado.\n");
                int opcao;
                do {
                    System.out.println("Escolha uma opção: ");
                    System.out.println("1. Cadastrar professor\n2. Voltar ao menu\n");
                    opcao = leitura.nextInt();
                    leitura.nextLine();

                    switch (opcao) {
                        case 1:
                            ProfessorController.cadastrarProfessor();
                            ministrante = ProfessorController.buscarProfessorPorNome(NomeMinistrante); // Atualiza a variável ministrante
                            break;
                        case 2:
                            CursoView.enviarMenuCurso();
                            return;
                        default:
                            System.out.println("Opção inválida.\n");
                            break;
                    }
                } while (opcao <= 0 || opcao >= 3);
            }

            turma = new ArrayList<>();
            Curso NovoCurso = new Curso(nomeCurso, cargaHoraria, ministrante, turma);

            // Garantir que a lista não é nula antes de adicionar
            if (Curso.getCursos() == null) {
                Curso.setCursos(new ArrayList<>());
            }
            Curso.getCursos().add(NovoCurso);

            System.out.println("Curso cadastrado com sucesso!\nNome: " + NovoCurso.getNomeCurso() +
                    "\nCarga horária: " + NovoCurso.getCargaHoraria() +
                    "\nProfessor: " + NovoCurso.getProfessor().getNome() + "\n");

            validacao = true;

        } while (!validacao);

        System.out.println("Voltando ao Menu de cursos...\n");
        Main.enviarMenu();
    }

    public static void consultarCurso(){
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        boolean encontrado = false;
        Curso cursoEncontrado = null;

        do{
            System.out.println("Digite o nome do curso que deseja consultar: ");
            nomeCurso = leitura.nextLine();

            if(nomeCurso.isEmpty()){
                System.out.println("Para editar um curso é necessário o nome do curso cadastrado.");
            }
        }while(nomeCurso.isEmpty());

        if(Curso.buscarCursoPorNome(nomeCurso) != null){
            cursoEncontrado = Curso.buscarCursoPorNome(nomeCurso);
                    encontrado = true;
        }

        if(encontrado == false){
            System.out.println("Curso não encontrado: Voltando para o Menu.");
            Main.enviarMenu();
        }

        System.out.println("Nome: "+ cursoEncontrado.getNomeCurso() + "\nCarga horária: "+ cursoEncontrado.getCargaHoraria() + "\nProfessor ministrante: "+ cursoEncontrado.getProfessor() + "\n");
        System.out.println("Voltando para o menu.");
        Main.enviarMenu();
        //leitura.close();
    }

    public static void editarCurso(){
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        boolean encontrado = false;
        Curso cursoEncontrado;

        do{
            System.out.println("Digite o nome do curso que deseja editar: ");
            nomeCurso = leitura.nextLine();

            if(nomeCurso.isEmpty()){
                System.out.println("Para editar um curso é necessário o nome do curso cadastrado.\n");
            }
        }while(nomeCurso.isEmpty());

        if(Curso.buscarCursoPorNome(nomeCurso) != null){
            cursoEncontrado = Curso.buscarCursoPorNome(nomeCurso);
            encontrado = true;
        }

        if(encontrado){
            int opcao;

            System.out.println("Curso " + nomeCurso + "não encontrado.\n");
            System.out.println("1. Cadastrar novo curso\n2. Voltar ao menu.\n");
            opcao = leitura.nextInt();

            do{
                switch(opcao){
                    case 1:
                        CursoController.cadastrarCurso();
                        break;
                    case 2:
                        CursoView.enviarMenuCurso();
                        break;
                    default:
                        System.out.println("Opção digitada inválida.Voltando ao menu de cursos\n");
                        CursoView.enviarMenuCurso();
                        break;
                }
            }while(opcao <= 0 || opcao >= 3);
        }else{
            CursoView.menuEdicao();
        }

        Main.enviarMenu();
        //leitura.close();
    }   //error

    public static void excluirCurso(){
        Scanner leitura = new Scanner(System.in);
        String nomeCurso;
        Curso cursoEncontrado;
        boolean encontrado = false;

        do{
            System.out.println("Digite o nome do curso que deseja excluir: ");
            nomeCurso = leitura.nextLine();

            if(nomeCurso.isEmpty()){
                System.out.println("Para editar um curso é necessário o nome do curso cadastrado.");
            }
        }while(nomeCurso.isEmpty());

        if(Curso.buscarCursoPorNome(nomeCurso) != null){
            cursoEncontrado = Curso.buscarCursoPorNome(nomeCurso);
            encontrado = true;
        }

        if(encontrado){
            System.out.println("O curso " + nomeCurso + "não foi encontrado.\nVoltando para o Menu de cursos");
            CursoView.enviarMenuCurso();
        }else{
            boolean excluido;

            excluido = Curso.excluirCursoPorNome(nomeCurso);

            if(excluido){
                System.out.println("O curso não foi excluido\n");
                CursoController.consultarCurso();
            }
            System.out.println("Curso removido com sucesso!.Voltando ao menu.\n");
            CursoView.enviarMenuCurso();
        }
        //leitura.close();
    }     //error

    //metodos de edição e busca
    public static void alterarNome(String nome){
        Scanner leitura = new Scanner(System.in);
        String novoNome;
        Curso encontrado;

        System.out.println("Digite o novo nome para o curso:");
        novoNome = leitura.nextLine();

        encontrado = Curso.buscarCursoPorNome(nome);

        System.out.println("Nome do curso alterado com sucesso!: " + encontrado.getNomeCurso());

        System.out.println("Voltando para o menu.");
        Main.enviarMenu();

        //leitura.close();
    }      //error

    public static void alterarCargaHoraria(String nome){
        Scanner leitura = new Scanner(System.in);
        int novaCH;
        Curso encontrado;

        encontrado = Curso.buscarCursoPorNome(nome);

        System.out.println("Digite a nova carga horária para o curso:");
        novaCH = leitura.nextInt();

        encontrado.setCargaHoraria(novaCH);

        System.out.println("Carga Horária do curso alterada com sucesso!: " + encontrado.getCargaHoraria());

        System.out.println("Voltando para o menu.");
        Main.enviarMenu();

        //leitura.close();
    }

    public static void alterarProfessor(String nomeCurso){
        ProfessorController.editarProfessor(nomeCurso);

        System.out.println("Voltando para o menu.");
        Main.enviarMenu();
    }
}