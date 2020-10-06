package domain;

import java.util.Scanner;

public class Disciplina {

	private String nome;
	private int cargaHoraria;
	private double[] notas = new double[3];
	private Professor professor;

	@Override
	public String toString() {
		return "Nome: " + this.nome + " | Carga Horária: " + this.cargaHoraria + " | Professor: " + this.professor;
	}
	public double calculaMedia() {
		return (notas[0] + notas[1] + notas[2]) / 3;
	}
	public boolean hasProfessorComFormacao(int formacao) {
		return professor.getFormacao() == formacao;
	}
	public void cadastraDisciplina() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		this.setNome(scan.nextLine());
		System.out.println("Digite a carga horaria: ");
		this.setCargaHoraria(scan.nextInt());
		Professor p = new Professor();
		p.cadastarProfessor();
		this.setProfessor(p);
		
		System.out.println("Digite suas 3 notas: ");
		double[] tempNotas = new double[3];
		for (int i=0; i<3; i++) {
			tempNotas[i] = scan.nextDouble();
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public double[] getNotas() {
		return notas;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
}
