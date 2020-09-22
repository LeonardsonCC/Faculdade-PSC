package imc;

import java.text.DecimalFormat;

public class Pessoa {
	
	private String nome;
	private double altura;
	private double peso;
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###.00");
		
		String retorno = "";
		retorno += getNome() + "\n"; 
		retorno += "IMC: " + df.format(getImc()) + "\n";
		retorno += getAvaliaImc();
		return retorno;
	}
	
	public double getImc() {
		return peso / (altura * altura);
	}
	
	public String getAvaliaImc() {
		double imc = this.getImc();
		if (imc < 18) {
			return "abaixo do peso";
		} else {
			if (imc > 25) {
				return "acima do peso";
			} else {
				return "peso ideal";
			}
		}
	}
	
	public String getNome() {
		return nome.toUpperCase();
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
