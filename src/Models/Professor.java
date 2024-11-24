package model;

public class Professor {
	private String nome;
	private int idade;
	private String especialidade;
	private String cpf;

	// Construtor
	public Professor(String nome, int idade, String especialidade, String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.especialidade = especialidade;
		this.cpf = cpf;
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getCpf() {
		return cpf;
	}

	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
