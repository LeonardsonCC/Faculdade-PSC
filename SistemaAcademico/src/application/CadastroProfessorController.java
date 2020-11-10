package application;

import java.util.ArrayList;

import domain.Professor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CadastroProfessorController {

    @FXML private TextField txtNome;
    @FXML private TextField txtNascimento;
    @FXML private ToggleGroup grpSexo;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEmail;
    @FXML private CheckBox cbAtivo;
    @FXML private TextField txtFiltro;   
    @FXML private RadioButton rdMasc;
    @FXML private RadioButton rdFem;
    
    @FXML TableView<Professor> tbl;
	@FXML TableColumn<Professor, String> colNome;
	@FXML TableColumn<Professor, String> colEmail;
	@FXML TableColumn<Professor, String> colTelefone;
    
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public void initialize() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		colTelefone.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
	}

	@FXML
	public void gravar() {
		Professor p = new Professor();
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
		professores.add(p);
		tbl.setItems(FXCollections.observableArrayList(professores));
		
		limpaTela();
	}
	
	@FXML
	public void clicouTbl(){
		Professor p = tbl.getSelectionModel().getSelectedItem();
		
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
		Professor p = tbl.getSelectionModel().getSelectedItem();
		if(p != null) {
			professores.remove(p);
			tbl.setItems(FXCollections.observableArrayList(professores));
		}
		
		limpaTela();
	}
	
	@FXML
	public void filtrar() {
		String filtro = txtFiltro.getText().toLowerCase();
		ArrayList<Professor> filtradas = new ArrayList<Professor>();
		for (Professor p : professores) {
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
