package application;

import java.util.ArrayList;

import domain.Disciplina;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TabDisciplinaController {

	@FXML TextField txtNome;
	@FXML TextField txtCargaHoraria;
	@FXML TextField txtFiltrar;
	@FXML CheckBox ckAtiva;
	@FXML TableView<Disciplina> tbl;
	@FXML TableColumn<Disciplina, String> colNome;
	@FXML TableColumn<Disciplina, Number> colCargaHoraria;
	@FXML TableColumn<Disciplina, Boolean> colAtiva;
	
	private ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	
	@FXML
	public void initialize() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colCargaHoraria.setCellValueFactory(cellData -> cellData.getValue().cargaHorariaProperty());
		colAtiva.setCellValueFactory(cellData -> cellData.getValue().ativaProperty());
	}
	
	@FXML
	public void gravar() {
		Disciplina d = new Disciplina();
		d.setNome(txtNome.getText());
		d.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
		d.setAtiva(ckAtiva.isSelected());
		listaDisciplina.add(d);
		tbl.setItems(FXCollections.observableArrayList(listaDisciplina));
		limpaTela();
	}
	
	@FXML
	public void clicouTbl() {
		Disciplina d = tbl.getSelectionModel().getSelectedItem();
		if (d != null) {
			txtNome.setText(d.getNome());
			txtCargaHoraria.setText(String.valueOf(d.getCargaHoraria()));
			ckAtiva.setSelected(d.isAtiva());
		}
	}
	
	@FXML
	public void excluir() {
		Disciplina d = tbl.getSelectionModel().getSelectedItem();
		if (d != null) {
			listaDisciplina.remove(d);
			tbl.setItems(FXCollections.observableArrayList(listaDisciplina));
		}
		limpaTela();
	}
	
	@FXML
	public void filtrar() {
		String filtro = txtFiltrar.getText().toUpperCase();
		ArrayList<Disciplina> filtradas = new ArrayList<Disciplina>();
		for(Disciplina d: listaDisciplina) {
			if (d.getNome().toUpperCase().startsWith(filtro)) {
				filtradas.add(d);
			}
		}
		tbl.setItems(FXCollections.observableArrayList(filtradas));
	}
	
	private void limpaTela() {
		txtNome.setText("");
		txtCargaHoraria.setText("");
		ckAtiva.setSelected(false);
	}
	
}
