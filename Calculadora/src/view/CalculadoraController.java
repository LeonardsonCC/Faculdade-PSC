package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;

    @FXML
    private TextField txtResult;

    @FXML
    void division() {
    	double number1 = Double.parseDouble(txtNumber1.getText());
    	double number2 = Double.parseDouble(txtNumber2.getText());
    	
    	double result = number1 / number2;
    	txtResult.setText(String.valueOf(number1) + " / " + String.valueOf(number2) + " = " + String.valueOf(result));
    }

    @FXML
    void multiplicate() {
    	double number1 = Double.parseDouble(txtNumber1.getText());
    	double number2 = Double.parseDouble(txtNumber2.getText());
    	
    	double result = number1 * number2;
    	txtResult.setText(String.valueOf(number1) + " * " + String.valueOf(number2) + " = " + String.valueOf(result));
    }

    @FXML
    void sub() {
    	double number1 = Double.parseDouble(txtNumber1.getText());
    	double number2 = Double.parseDouble(txtNumber2.getText());
    	
    	double result = number1 - number2;
    	txtResult.setText(String.valueOf(number1) + " - " + String.valueOf(number2) + " = " + String.valueOf(result));
    }

    @FXML
    void sum() {
    	double number1 = Double.parseDouble(txtNumber1.getText());
    	double number2 = Double.parseDouble(txtNumber2.getText());
    	
    	double result = number1 + number2;
    	txtResult.setText(String.valueOf(number1) + " + " + String.valueOf(number2) + " = " + String.valueOf(result));
    }

}
