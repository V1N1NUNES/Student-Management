package models;

import java.util.ArrayList;

public class Professor extends Pessoa{
    private String nome;
    private int idade;
    private String especialidade;
    private ArrayList<Professor> professores;


    //Construtor de professor
    public Professor(String nome, int idade, String Especialidade){
        super(nome, idade);
        this.especialidade = Especialidade;
    }


    //getters and stters
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

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    @Override
    public void exibirDados() {
        System.out.println("Informações do professor:\n");
        System.out.println("Nome do professor: "+ getNome());
        System.out.println("Idade: "+ getIdade());
        System.out.println("Especialidade: "+ getEspecialidade());
    }
}
