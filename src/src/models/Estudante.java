package models;

import java.util.ArrayList;

public class Estudante extends Pessoa {
    private String matricula;
    public static ArrayList<Estudante> estudantes = new ArrayList<Estudante>();


    //construtor da classe
    public Estudante(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }



    //getters and setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void addEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void removeEstudante(Estudante estudante) {
        estudantes.remove(estudante);
    }

    @Override
    public void exibirDados() {
        System.out.println("Informações do Estudante: ");
        System.out.println("- Nome: " + getNome());
        System.out.println("- Idade: " + getIdade());
        System.out.println("- Matricula: " + getMatricula());
    }
}

