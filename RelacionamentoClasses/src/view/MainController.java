package view;

import java.util.ArrayList;

import domain.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController {

	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtIdade;
	@FXML
	private RadioButton rbMasc;
	@FXML
	private ToggleGroup sexo;
	@FXML
	private RadioButton rbFemi;
	@FXML
	private TextField txtTitulo;
	@FXML
	private TextField txtAno;
	@FXML
	private TextField txtValor;
	@FXML
	private TextArea txtResultado;
	
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	private void limpaTela() {
		txtNome.setText("");
		txtIdade.setText("");
		txtTitulo.setText("");
		txtAno.setText("");
		txtValor.setText("");
		rbMasc.setSelected(false);
		rbFemi.setSelected(true);
	}
	
	@FXML
	void btnBuscarNome() {
		txtResultado.setText("");
		String nomeBusca = txtNome.getText();
		for (Pessoa pessoa: pessoas) {
			if (pessoa.getNome().toUpperCase().startsWith(nomeBusca.toUpperCase())) {
				txtResultado.appendText(pessoa.toString());
			}
		}
		limpaTela();
	}

	@FXML
	void btnCadastrar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(txtNome.getText());
		pessoa.setIdade(Integer.parseInt(txtIdade.getText()));
		pessoa.setSexo(rbMasc.isSelected() ? 'M' : 'F');
		pessoa.getDvd().setTitulo(txtTitulo.getText());
		pessoa.getDvd().setAno(Integer.parseInt(txtAno.getText()));
		pessoa.getDvd().setValor(Double.parseDouble(txtValor.getText()));
		
		txtResultado.setText("");
		for (Pessoa p: pessoas) {
			txtResultado.appendText(p.toString() + "\n");
		}
		limpaTela();
	}

	@FXML
	void btnDvdMaisCaro() {
		txtResultado.setText("");
		Pessoa pessoaDvdMaisCaro = new Pessoa();
		for (Pessoa pessoa: pessoas) {
			if (pessoa.getDvd().getValor() > pessoaDvdMaisCaro.getDvd().getValor()) {
				pessoaDvdMaisCaro = pessoa;
			}
		}
		txtResultado.setText(pessoaDvdMaisCaro.toString());
	}

	@FXML
	void btnListarPorSexo() {
		txtResultado.setText("");
		char sexo = rbMasc.isSelected() ? 'M' : 'F';
		for (Pessoa pessoa: pessoas) {
			if(pessoa.getSexo() == sexo) {
				txtResultado.appendText(pessoa.toString());
			}
		}
		limpaTela();
	}

}
