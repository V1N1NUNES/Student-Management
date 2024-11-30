package models;

public abstract class Pessoa {
    private String nome;  // Armazena o nome da pessoa.
    private int idade;  // Armazena a idade da pessoa.

    // Construtor da classe: inicializa o nome e a idade.
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters para acessar e modificar o nome e a idade.
    @Override
    public String toString() {
        return nome; // Retorna o nome do professor ao invés da representação padrão do objeto
    }

    public String getNome() {
        return nome;  // Retorna o nome da pessoa.
    }

    public void setNome(String nome) {
        this.nome = nome;  // Define o nome da pessoa.
    }

    public int getIdade() {
        return idade;  // Retorna a idade da pessoa.
    }

    public void setIdade(int idade) {
        this.idade = idade;  // Define a idade da pessoa.
    }

    // Método abstrato a ser implementado pelas subclasses para exibir os dados.
    public abstract void exibirDados();
}

