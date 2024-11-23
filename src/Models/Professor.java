package model;

public class Professor {
	private int idade;
	private String nome;
	private String especialidade;
	private String cpf;
	
	public Professor(String nome,int idade, String especialidade,String cpf) {
		
		this.nome = nome;
		this.idade = idade;
		this.especialidade = especialidade;
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	public String getNome() {
		return nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void SetIdade(int idade) {
		if (idade < 0) {
			throw new IllegalArgumentException("Idade não pode ser negativa");
		}if (idade < 18) {
			throw new IllegalArgumentException("Professores não podem ser menores de idade");
		}
		this.idade = idade;
	}
	public void SetNome(String nome) {
		this.nome = nome;
	}
	public void SetEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public void SetCPF(String cpf) {
		this.cpf = cpf;
	}
}
