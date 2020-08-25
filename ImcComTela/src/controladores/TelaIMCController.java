package controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaIMCController {

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtAltura;

    @FXML
    private Label lblResultado;

    @FXML
    void calculaImc() {
    	if (txtPeso.getText().equals("") || txtAltura.getText().equals("")) return;
    	double peso = Double.parseDouble(txtPeso.getText());
    	double altura = Double.parseDouble(txtAltura.getText());
    	
    	double resultado = peso / (altura * altura);
    	
    	lblResultado.setText("Resultado: " + resultado);
    }

}
