package models;

// Define a classe Professor que estende a classe abstrata Pessoa
public class Professor extends Pessoa {
    // Atributo privado para armazenar a especialidade do professor
    private String especialidade;

    // Construtor que inicializa os atributos nome, idade (da classe Pessoa) e especialidade
    public Professor(String nome, int idade, String especialidade) {
        super(nome, idade); // Chama o construtor da classe Pessoa
        this.especialidade = especialidade;
    }

    // Método getter para o atributo especialidade
    public String getEspecialidade() {
        return especialidade;
    }

    // Método setter para o atributo especialidade
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Implementação do método abstrato exibirDados da classe Pessoa
    @Override
    public void exibirDados() {
        System.out.println("\nInformações do professor:");
        System.out.println("Nome: " + getNome()); // Utiliza o método getNome da classe Pessoa
        System.out.println("Idade: " + getIdade()); // Utiliza o método getIdade da classe Pessoa
        System.out.println("Especialidade: " + especialidade);
    }
}
