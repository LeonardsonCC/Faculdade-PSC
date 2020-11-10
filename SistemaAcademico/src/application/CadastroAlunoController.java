package application;

import java.util.ArrayList;

import domain.Aluno;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CadastroAlunoController {

    @FXML private TextField txtNome;
    @FXML private TextField txtNascimento;
    @FXML private ToggleGroup grpSexo;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEmail;
    @FXML private CheckBox cbAtivo;
    @FXML private TextField txtFiltro;   
    @FXML private RadioButton rdMasc;
    @FXML private RadioButton rdFem;
    
    @FXML TableView<Aluno> tbl;
	@FXML TableColumn<Aluno, String> colNome;
	@FXML TableColumn<Aluno, String> colEmail;
	@FXML TableColumn<Aluno, String> colTelefone;
    
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public void initialize() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		colTelefone.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
	}

	@FXML
	public void gravar() {
		Aluno p = new Aluno();
		p.setNome(txtNome.getText());
		p.setNascimento(txtNascimento.getText());
		
		if(rdMasc.isSelected()) {
			p.setSexo("Masculino");
		}
		else {
			p.setSexo("Feminino");
		}

		p.getSexo();
		p.setEmail(txtEmail.getText());
		p.setTelefone(txtTelefone.getText());
		p.setAtiva(cbAtivo.isSelected());
		alunos.add(p);
		tbl.setItems(FXCollections.observableArrayList(alunos));
		
		limpaTela();
	}
	
	@FXML
	public void clicouTbl(){
		Aluno p = tbl.getSelectionModel().getSelectedItem();
		
		if(p != null) {
			txtNome.setText(p.getNome());
			txtNascimento.setText(p.getNascimento());
			if(p.getSexo() == "Masculino") {
				rdMasc.setSelected(true);
			}
			else {
				rdFem.setSelected(true);
			}
			txtEmail.setText(p.getTelefone());
			txtTelefone.setText(p.getTelefone());
			cbAtivo.setSelected(p.isAtiva());
		}
	}
	
	@FXML
	public void excluiLinha() {
		Aluno p = tbl.getSelectionModel().getSelectedItem();
		if(p != null) {
			alunos.remove(p);
			tbl.setItems(FXCollections.observableArrayList(alunos));
		}
		
		limpaTela();
	}
	
	@FXML
	public void filtrar() {
		String filtro = txtFiltro.getText().toLowerCase();
		ArrayList<Aluno> filtradas = new ArrayList<Aluno>();
		for (Aluno p : alunos) {
			if(p.getNome().toLowerCase().startsWith(filtro))
				filtradas.add(p);
		}
		tbl.setItems(FXCollections.observableArrayList(filtradas));
	}
	
	public void limpaTela() {
		txtNome.setText("");
		txtNascimento.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		cbAtivo.setSelected(false);
	}
}

