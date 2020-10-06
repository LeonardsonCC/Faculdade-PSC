package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
	
	private String nome;
	private ArrayList<Disciplina> listaDisciplinas;
	

	@Override
	public String toString() {
		String retorno = "";
		retorno += "Nome: " + nome;
		for (Disciplina d: this.listaDisciplinas) {
			retorno += "Disciplina: " + d;
		}
		return retorno;
	}
	public void cadastraAluno() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		this.setNome(scan.nextLine());
		System.out.println("Agora o cadastro de disciplinas do aluno:");
		int opt = 0;
		do {
			Disciplina d = new Disciplina();
			d.cadastraDisciplina();
			this.addDisciplina(d);
			
			System.out.println("Para cadastrar outra digite 1. Caso não, digite 0");
			opt = scan.nextInt();
		} while(opt != 0);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void addDisciplina(Disciplina disciplina) {
		this.listaDisciplinas.add(disciplina);
	}

	public void mostraMedias() {
		for(Disciplina d: this.listaDisciplinas) {
			System.out.println(d.getNome() + " - " + d.calculaMedia());
		}
	}
	public void mostraDisciplinasComPos() {
		for(Disciplina d: this.listaDisciplinas) {
			if (d.hasProfessorComFormacao(3)) {
				System.out.println(d.getNome());
			}
		}
	}
	
}
