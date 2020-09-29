package domain;

import javax.swing.JOptionPane;

public class Dvd {

	private String titulo;
	private int ano;
	private double valor;
	
	public void cadastrarJopt() {
		setTitulo(JOptionPane.showInputDialog("Título do DVD:"));
		setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento:")));
		setValor(Double.parseDouble(JOptionPane.showInputDialog("Título do DVD:")));
	}
	
	@Override
	public String toString() {
		return getTitulo() + ";" + getAno() + ";" + getValor() + ";" + "\n";
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
