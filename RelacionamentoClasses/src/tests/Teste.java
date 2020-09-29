package tests;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Dvd;

public class Teste {

	static ArrayList<Dvd> dvdList = new ArrayList<Dvd>();
	
	public static void main(String[] args) {
		String menu = "1 - Cadastrar DVD\n"
				+ "2 - Listar todos\n"
				+ "3 - Somar valores\n"
				+ "4 - Buscar por ano\n"
				+ "5 - Buscar por título\n"
				+ "0 - Sair\n";
		int op = 0;
		String r;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch(op) {
			case 1:
				Dvd d = new Dvd();
				d.cadastrarJopt();
				dvdList.add(d);
				break;
				
			case 2:
				r = "DVDs Cadastrados\n";
				for (Dvd dvd: dvdList) {
					r += dvd;
				}
				JOptionPane.showMessageDialog(null, r);
				break;
				
			case 3:
				double total = 0;
				for (Dvd dvd: dvdList) {
					total += dvd.getValor();
				}
				JOptionPane.showMessageDialog(null, total);
				break;
				
			case 4:
				int anoBusca = Integer.parseInt(JOptionPane.showInputDialog("Qual ano buscar?"));
				r = "DVDs do ano " + anoBusca + "\n";
				for (Dvd dvd: dvdList) {
					if (anoBusca == dvd.getAno()) {
						r += dvd;
					}
				}
				JOptionPane.showMessageDialog(null, r);
				break;
				
			case 5:
				int tituloBusca = Integer.parseInt(JOptionPane.showInputDialog("Qual ano buscar?"));
				r = "DVDs com o título " + tituloBusca + "\n";
				for (Dvd dvd: dvdList) {
					if (tituloBusca == dvd.getAno()) {
						r += dvd;
					}
				}
				JOptionPane.showMessageDialog(null, r);
				break;
			}
		} while (op != 0);
	}
	
}
