package src.models;

public class Professor {
    private String nome;
    private int idade;
    private String disciplina;
    private String cpf;

    // Construtor
    public Professor(String nome, int idade, String disciplina, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.disciplina = disciplina;
        this.cpf = cpf;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getCpf() {
        return cpf;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void exibirDados() {
        System.out.println("--------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Disciplina: " + disciplina);
        System.out.println("--------------------------\n");
    }
}