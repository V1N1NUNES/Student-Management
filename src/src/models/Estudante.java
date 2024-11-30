package models;

import java.util.ArrayList;

public class Estudante extends Pessoa {
    private String matricula;  // Armazena a matrícula do estudante.
    public static ArrayList<Estudante> estudantes = new ArrayList<>();  // Lista estática de todos os estudantes.

    // Construtor da classe: inicializa nome, idade e matrícula do estudante.
    public Estudante(String nome, int idade, String matricula) {
        super(nome, idade);  // Chama o construtor da classe Pessoa.
        this.matricula = matricula;
    }

    // Getters e Setters para acessar e modificar a matrícula.
    public String getMatricula() {
        return matricula;  // Retorna a matrícula do estudante.
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;  // Define a matrícula do estudante.
    }

    @Override
    public void exibirDados() {
        // Sobrescreve o método exibirDados para exibir as informações do estudante.
        System.out.println("Informações do Estudante: ");
        System.out.println("- Nome: " + getNome());
        System.out.println("- Idade: " + getIdade());
        System.out.println("- Matrícula: " + getMatricula());
    }
}


