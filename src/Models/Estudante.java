package src.Classes;

import java.util.Scanner;

public class Estudante extends Pessoa{
    double matricula;

    //construtor da classe "Pessoa" com a implementação de "Matricula"
    public Estudante(String Nome, int Idade, double Matricula) {
        super(Nome, Idade);
        this.matricula = Matricula;
    }

    //metodos getters and stters
    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    //Os getters and stters de "nome" e "idade" ja estão declarados em "Pessoa"


    //metodos
    private void cadastro(){
        //implementar o código....
    }

    public void consultar(){
        //implementar o código...
    }

    private void edicao(double Matricula){
        //implementar o código...
    }

    private void exclusao(double Matricula){
        //implementar o código...
    }



    public void MenuEstudante(Scanner leitura){
        int opcao;
        boolean Opcao = true;

        do{
            System.out.println("MENU ESTUDANTE\n\n1- Cadastrar\n2- Consultar\n3- Editar\n4- Excluir\n5- Menu principal");
            opcao = leitura.nextInt();

            switch(opcao){
                case 1:
                    //implementar
                    break;
                case 2:
                    //implementar
                    break;
                case 3:
                    //implementar
                    break;
                case 4:
                    //implementar
                    break;
                case 5:
                    System.out.println("Voltando ao Menu principal...\n\n");
                    //Menu principal
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        }while(Opcao == false);

    }
}
