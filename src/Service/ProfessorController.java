package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Professor;

public class ProfessorController {
    private List<Professor> professores = new ArrayList<>();

    public void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira aqui o nome do professor:");
        String nome = scanner.nextLine();

        System.out.println("Insira aqui a idade do professor:");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Insira aqui a especialidade do professor:");
        String especialidade = scanner.nextLine();

        System.out.println("Insira aqui o CPF do professor:");
        String cpf = scanner.nextLine();

        // Verificar se o CPF contém apenas números
        if (!cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido! Deve conter exatamente 11 dígitos numéricos.");
            
            scanner.close();
            return;
        }
        // Criar e cadastrar o professor
        Professor novoProfessor = new Professor(nome, idade, especialidade, cpf);
        professores.add(novoProfessor);

        System.out.println("Cadastro realizado com sucesso!");
    
        scanner.close();
    }

    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados!");
        } else {
            System.out.println("Lista de professores:");
            for (var professor : professores) {
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Idade: " + professor.getIdade());
                System.out.println("Especialidade: " + professor.getEspecialidade());
                System.out.println("-----------------------------");
            }
        }
    }

    public void consultarProfessor() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o Nome do professor que desejas procurar:");
        String nome = scanner.nextLine();
        
        System.out.println("Digite o CPF do professor que desejas procurar:");
        String cpf = scanner.nextLine();

        boolean encontrado = false;

        for (var professor : professores) {
            if (professor.getCpf().equals(cpf) && professor.getNome().equals(nome)) {
                System.out.println("Professor encontrado!");
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Idade: " + professor.getIdade());
                System.out.println("Especialidade: " + professor.getEspecialidade());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("O professor não está cadastrado.");
        }
        scanner.close();
    }

    public void excluirProfessor() {
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;
        
        System.out.println("Digie o Nome do professor que desejas excluir: ");
        String nome = scanner.nextLine();
        
        System.out.println("Digite o CPF do professor que desejas excluir: ");
        String cpf = scanner.nextLine();
        
        var iterator = professores.iterator();
        while(iterator.hasNext()) {
        	var professor = iterator.next();
        	if (professor.getCpf().equals(cpf)) {
        		iterator.remove();
        		System.out.println("Professor foi excluido com sucesso!");
        		
        		encontrado = true;
        	}
        }
        if (!encontrado) {
        	System.out.println("Professor não encontrado!");
        }

        scanner.close();
    }
    
    public void editarProfessor() {
    	Scanner scanner = new Scanner(System.in);
    	boolean encontrado = false;
          
          System.out.println("Digite o CPF do professor que desejas encontrar: ");
          String cpf = scanner.nextLine();
          
          var iterator = professores.iterator();
          while(iterator.hasNext()) {
          	var professor = iterator.next();
          	
          	if (professor.getCpf().equals(cpf)) {
          		encontrado = true;
          		
          	
          	}

          }
    }
}
    