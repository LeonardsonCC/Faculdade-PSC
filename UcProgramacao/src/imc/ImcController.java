package imc;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ImcController {

	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtPeso;
	@FXML
	private TextField txtAltura;
	@FXML
	private Button btnCalcular;
	@FXML
	private Button btnCalcular1;
	@FXML
	private Label lblCadastrados;
	@FXML
	private TextArea txtResultado;

	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	@FXML
	void cadastrar() {
		if (!validou()) {
			return;
		}
		
		String nome = txtNome.getText();
		double peso = Double.parseDouble(txtPeso.getText());
		double altura = Double.parseDouble(txtAltura.getText());

		Pessoa p = new Pessoa();
		p.setNome(nome);
		p.setAltura(altura);
		p.setPeso(peso);
		listaPessoas.add(p);
		lblCadastrados.setText("Pessoas cadastradas: " + listaPessoas.size());

		txtNome.setText("");
		txtPeso.setText("");
		txtAltura.setText("");
		txtNome.requestFocus();
	}

	@FXML
	void calcular() {
		txtResultado.setText("");

		for (Pessoa p : listaPessoas) {
			txtResultado.appendText(p.toString() + "\n==========================\n");
		}
	}

	private boolean validou() {
		if (txtNome.getText().equals("")) {
			Mensagem.mostrarErro("Erro de validação", "Nome é obrigatório", "Cadastro de pessoas");
			return false;
		}
		if (txtPeso.getText().equals("")) {
			Mensagem.mostrarErro("Erro de validação", "Peso é obrigatório", "Cadastro de pessoas");
			return false;
		}
		if (txtAltura.getText().equals("")) {
			Mensagem.mostrarErro("Erro de validação", "Altura é obrigatório", "Cadastro de pessoas");
			return false;
		}
		return true;
	}

}
