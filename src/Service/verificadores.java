package services;


public class verificadores {
	public static String limparCPF(String cpf) {
		return cpf.replaceAll("[^\\d ]","");
		}
}
