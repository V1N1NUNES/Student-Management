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


    public void MenuProfessor(Scanner leitura){
        int opcao;
        boolean Opcao = true;

        System.out.println("MENU PROFESSOR\n\n1- cadastrar professor\n2- Consultar professor\n3- Editar informações\n4- excluir professor\n5- Menu principal\n");
        opcao = leitura.nextInt();

        do{
            switch (opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Voltando ao Menu principal...\n\n");
                    //Menu principal
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(Opcao == false);
    }
}
