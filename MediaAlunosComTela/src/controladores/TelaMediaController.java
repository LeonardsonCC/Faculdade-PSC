package controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaMediaController {

	@FXML
	private TextField txtNomeAluno;

	@FXML
	private TextField txtNota1;

	@FXML
	private TextField txtNota2;

	@FXML
	private TextField txtNota3;

	@FXML
	private Label lblMedia;

	@FXML
	private Label lblSituacao;

	@FXML
	private Label lblNomeAluno;

	@FXML
	void calculaMedia() {
		String nomeAluno = txtNomeAluno.getText();
		double notas[] = new double[3];
		notas[0] = Double.parseDouble(txtNota1.getText());
		notas[1] = Double.parseDouble(txtNota2.getText());
		notas[2] = Double.parseDouble(txtNota3.getText());

		double mediaAluno = (notas[0] + notas[1] + notas[2]) / 3;
		lblNomeAluno.setText(nomeAluno);
		lblMedia.setText(String.valueOf(mediaAluno));

		if (mediaAluno >= 7) {
			lblSituacao.setText("Aprovado");
		} else if (mediaAluno < 3) {
			lblSituacao.setText("Reprovado");
		} else {
			lblSituacao.setText("Recuperação");
		}

	}

}
