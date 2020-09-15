package exercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Exercicio2Controller {

	@FXML
	private TextField txtQuantidadeFuncionarios;
	@FXML
	private TextField txtNomeFuncionario;
	@FXML
	private TextField txtSalario;
	@FXML
	private TextArea txtResultado;

	private String[] vetorNomes;
	private double[] vetorSalarios;
	private int indiceAtual;

	@FXML
	void iniciaVetores() {
		int quantidadeFuncionarios = Integer.parseInt(this.txtQuantidadeFuncionarios.getText());

		this.vetorNomes = new String[quantidadeFuncionarios];
		this.vetorSalarios = new double[quantidadeFuncionarios];
		this.indiceAtual = 0;
	}

	@FXML
	void inserirFuncionario() {
		try {
			String nome = this.txtNomeFuncionario.getText();
			double salario = Double.parseDouble(this.txtSalario.getText());

			this.vetorNomes[this.indiceAtual] = nome;
			this.vetorSalarios[this.indiceAtual] = salario;

			this.indiceAtual++;
			
			this.resetaCampos();

			this.formataResultado();
		} catch (NullPointerException e) {
			System.err.println("Erro! Vetor não inicializado.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Erro! Limite do vetor foi ultrapassado.");
		} catch (NumberFormatException e) {
			System.err.println("Erro! Número inválido.");
		}
	}

	@FXML
	void atualizaFuncionarios() {
		for (int i = 0; i < this.vetorNomes.length; i++) {
			double salario = vetorSalarios[i];
			if (salario <= 400) {
				vetorSalarios[i] = vetorSalarios[i] * 1.25;
			} else {
				if (salario <= 600) {
					vetorSalarios[i] = vetorSalarios[i] * 1.2;
				} else {
					if (salario <= 800) {
						vetorSalarios[i] = vetorSalarios[i] * 1.15;
					} else {
						vetorSalarios[i] = vetorSalarios[i] * 1.1;
					}
				}
			}
		}
		formataResultado();

	}

	void formataResultado() {
		String resultado = "";
		for (int i = 0; i < this.vetorNomes.length; i++) {
			if (vetorNomes[i] != null && vetorSalarios[i] != 0) {
				resultado += vetorNomes[i] + " - " + vetorSalarios[i] + "\n";
			}
		}
		txtResultado.setText(resultado);
	}
	
	void resetaCampos() {
		this.txtNomeFuncionario.setText("");
		this.txtSalario.setText("");
	}
}
