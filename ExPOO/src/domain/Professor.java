package domain;

import java.util.Scanner;

public class Professor {

	private String nome;
	private int formacao; // 1- graduacao | 2 - especializacao | 3 - pos

	@Override
	public String toString() {
		String strFormacao = "";
		switch(formacao) {
		case 1:
			strFormacao = "Graduação"; break;
		case 2:
			strFormacao = "Especialização"; break;
		case 3:
			strFormacao = "Pós-Graduação"; break;
		}
		return "Nome: " + this.nome + " | " + strFormacao;
	}
	public void cadastarProfessor() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		this.setNome(scan.nextLine());
		System.out.println("Digite a formação: ");
		this.setFormacao(scan.nextInt());
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getFormacao() {
		return formacao;
	}
	public void setFormacao(int formacao) {
		this.formacao = formacao;
	}
	
}
