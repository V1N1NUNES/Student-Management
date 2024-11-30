package models;

// Define uma classe abstrata chamada Pessoa, que serve como uma classe base para outras classes.
public abstract class Pessoa {
    // Atributos privados da classe Pessoa.
    private String nome;
    private int idade;

    // Construtor que inicializa os atributos nome e idade.
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método sobrescrito que retorna o nome ao invés da representação padrão do objeto.
    @Override
    public String toString() {
        return nome; // Retorna o nome da pessoa.
    }

    // Método getter para o atributo nome.
    public String getNome() {
        return nome;
    }

    // Método setter para o atributo nome.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para o atributo idade.
    public int getIdade() {
        return idade;
    }

    // Método setter para o atributo idade.
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método abstrato que deve ser implementado pelas subclasses.
    public abstract void exibirDados();
}
