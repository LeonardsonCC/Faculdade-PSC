package imc;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagem {
	
	public static void mostrarErro(String titulo, String mensagem, String cabecalho) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(titulo);
		alert.setContentText(mensagem);
		alert.setHeaderText(cabecalho);
		alert.showAndWait();
	}
	
}
