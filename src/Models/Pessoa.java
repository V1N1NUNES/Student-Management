package src.Models;

//construtor da classe abstrata
abstract public class Pessoa {
    String nome;
    int idade;

    //metodos gatters and setters
    public Pessoa(String Nome, int Idade){
        this.nome = Nome;
        this.idade = Idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //metodos
    public void exibirDados(){
        System.out.println("Nome: " + getNome()+ "\nIdade: "+ getIdade());
    }
}
