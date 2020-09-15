package parimpar;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParImparController {

    @FXML private TextField txtQuantidadeNumeros;
    @FXML private TextField txtNumero;
    @FXML private TextArea txtResultado;
    
	private int[] vetor;
	private int indiceInicio;
	private int indiceFim;

    @FXML
    void criaVetor() {
    	// Cria novo vetor com a quantidade de posições digitada
    	int quantidadeNumeros = Integer.parseInt(txtQuantidadeNumeros.getText());
    	this.vetor = new int[quantidadeNumeros];
    	this.indiceInicio = 0;
    	this.indiceFim = quantidadeNumeros - 1;
    }

    @FXML
    void insereNumero() {
    	
    	// Obtém o número digitado e adiciona no vetor
    	int novoNumero = Integer.parseInt(txtNumero.getText());
    	
    	// Verifica se é par ou impar para a inserção
    	if (novoNumero % 2 == 0) {
    		// Par
    		vetor[indiceInicio] = novoNumero;
        	indiceInicio++;
    	} else {
    		// Ímpar
    		vetor[indiceFim] = novoNumero;
        	indiceFim--;
    	}
    		
    	// Limpa o campo de texto
    	txtNumero.setText("");
    	
    	
    	// Insere no campo resultado
    	String resultado = "";
    	for (int i=0; i < vetor.length; i++) {
    		if (vetor[i] != 0) {    			
    			resultado += vetor[i] + "\n";
    		}
    	}
    	txtResultado.setText(resultado);
    	
    	// Foco para o campo de inserir número
    	txtNumero.requestFocus();
    	
    }

}
