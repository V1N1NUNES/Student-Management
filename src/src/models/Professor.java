package models;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private String nome;
    private int idade;
    private String especialidade;

    // Lista estática de professores
    public static ArrayList<Professor> professores = new ArrayList<>();

    // Construtor de professor
    public Professor(String nome, int idade, String especialidade) {
        super(nome, idade);
        this.especialidade = especialidade;
    }

    // Getters e Setters
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    @Override
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public static ArrayList<Professor> getProfessores() {
        return professores;
    }

    // Métodos para adicionar e remover professores
    public static void addProfessor(Professor professor) {
        professores.add(professor);
    }

    public static void removeProfessor(Professor professor) {
        professores.remove(professor);
    }

    @Override
    public void exibirDados() {
        System.out.println("Informações do professor:\n");
        System.out.println("Nome do professor: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Especialidade: " + getEspecialidade());
    }
}
