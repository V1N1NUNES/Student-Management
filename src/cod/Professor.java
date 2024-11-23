package src.cod;

import src.Models.Pessoa;

import java.util.Scanner;

public class Professor extends Pessoa {
    String especialidade;

    //construtor da classe "Pessoa" com a implementação de "Especialidades"
    public Professor(String Nome, int Idade, String Especialidade) {
        super(Nome, Idade);
        this.especialidade = Especialidade;
    }

    //getters and stters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //Os getters and stters de "nome" e "idade" ja estão declarados em "Pessoa"

    //metodos
    private void cadastro(){
        //implementar o código....
    }

    private void consultar(){
        //implementar o código...
    }

    private void edicao(double Matricula){
        //implementar o código...
    }

    private void exclusao(double Matricula){
        //implementar o código...
    }



}
