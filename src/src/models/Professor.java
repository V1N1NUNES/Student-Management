package models;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private String especialidade;  // Armazena a especialidade do professor.
    private static ArrayList<Professor> professores = new ArrayList<>();  // Lista estática de todos os professores.

    // Construtor: inicializa o nome, idade e especialidade do professor.
    public Professor(String nome, int idade, String especialidade) {
        super(nome, idade);  // Chama o construtor da classe Pessoa.
        this.especialidade = especialidade;
    }

    // Getters e Setters para acessar e modificar a especialidade.
    public String getEspecialidade() {
        return especialidade;  // Retorna a especialidade do professor.
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;  // Define a especialidade do professor.
    }

    // Retorna a lista de todos os professores.
    public static ArrayList<Professor> getProfessores() {
        return professores;
    }

    // Adiciona um novo professor à lista estática.
    public static void addProfessor(Professor professor) {
        professores.add(professor);
    }

    // Remove um professor da lista estática.
    public static void removeProfessor(Professor professor) {
        professores.remove(professor);
    }

    @Override
    public void exibirDados() {
        System.out.println("\nInformações do professor:");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Especialidade: " + especialidade);
    }
}