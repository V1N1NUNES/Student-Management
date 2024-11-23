package services;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorServices {
	static private List<Professor> professores = new ArrayList<>();
	
	public static void cadastrarProfessor(String nome, int idade, String especialidade, String cpf) {
		Professor professor = new Professor(nome,idade,especialidade, cpf);
		professores.add(professor);
	}
	
	public static List<Professor> getProfessores(){
		return professores;
	}
	
}
