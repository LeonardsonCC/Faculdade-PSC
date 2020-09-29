package tests;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Pessoa;

public class TestePessoa {

	static ArrayList<Pessoa> pessoaList = new ArrayList<Pessoa>();
	
	public static void main(String[] args) {
		String menu = "1 - Cadastrar Pessoa\n"
				+ "2 - Listar por sexo\n"
				+ "3 - Listar por DVD\n"
				+ "4 - Pessoa com o DVD mais caro\n"
				+ "0 - Sair\n";
		int op = 0;
		String r;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch(op) {
			case 1:
				Pessoa p = new Pessoa();
				p.cadastrarJopt();
				pessoaList.add(p);
				break;
				
			case 2:
				char sexoBusca = JOptionPane.showInputDialog("Sexo (M/F)").toUpperCase().charAt(0);
				r = "Pessoas do Sexo " + sexoBusca;
				for (Pessoa pessoa: pessoaList) {
					if (pessoa.getSexo() == sexoBusca) {
						r += pessoa;
					}
				}
				break;
				
			case 3:
				String tituloBusca = JOptionPane.showInputDialog("Título do DVD");
				r = "DVDs com título";
				for (Pessoa pessoa: pessoaList) {
					if (pessoa.temDvdComTitulo(tituloBusca))
						r += pessoa;
				}
				JOptionPane.showMessageDialog(null, r);
				break;
				
			case 4:
				Pessoa pessoaComDvdMaisCaro = new Pessoa();
				for (Pessoa pessoa: pessoaList) {
					if (pessoa.getDvd().getValor() > pessoaComDvdMaisCaro.getDvd().getValor()) {
						pessoaComDvdMaisCaro = pessoa;
					}
				}
				JOptionPane.showMessageDialog(null, pessoaComDvdMaisCaro);
				
				break;
			}
		} while (op != 0);
	}
	
}
