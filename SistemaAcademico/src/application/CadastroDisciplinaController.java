package application;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DisciplinaDao;
import domain.Disciplina;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import util.Conexao;

public class CadastroDisciplinaController {

	@FXML TextField txtNome;
	@FXML TextField txtCargaHoraria;
	@FXML CheckBox ckAtiva;
	@FXML TableView<Disciplina> tbl;
	@FXML TableColumn<Disciplina, String> colNome;
	@FXML TableColumn<Disciplina, Number> colCargaHoraria;
	@FXML TableColumn<Disciplina, Boolean > colAtiva;
	@FXML TextField txtFiltro;

	private Disciplina disciplinaSelecionada = null;
	
	public void initialize() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colCargaHoraria.setCellValueFactory(cellData -> cellData.getValue().carga_horariaProperty());
		colAtiva.setCellValueFactory(cellData -> cellData.getValue().ativaProperty());
		exibirDisciplinas();
	}
	
	private void exibirDisciplinas() {
		ArrayList<Disciplina> lista = DisciplinaDao.listaTodas();
		tbl.setItems(FXCollections.observableArrayList(lista));
	}
	
	@FXML
	public void gravar() {
		if (disciplinaSelecionada == null) {			
			Disciplina d = new Disciplina();
			d.setNome(txtNome.getText());
			d.setCarga_horaria(Integer.parseInt(txtCargaHoraria.getText()));
			d.setAtiva(ckAtiva.isSelected());
			DisciplinaDao.novaDisciplina(d);
		} else {
			disciplinaSelecionada.setNome(txtNome.getText());
			disciplinaSelecionada.setCarga_horaria(Integer.parseInt(txtCargaHoraria.getText()));
			disciplinaSelecionada.setAtiva(ckAtiva.isSelected());
			DisciplinaDao.alteraDisciplina(disciplinaSelecionada);	
			disciplinaSelecionada = null;
		}
		limpaTela();
		exibirDisciplinas();
	}
	
	@FXML
	public void clicouTbl(){
		disciplinaSelecionada = tbl.getSelectionModel().getSelectedItem();
		
		if(disciplinaSelecionada != null) {
			txtNome.setText(disciplinaSelecionada.getNome());
			txtCargaHoraria.setText(disciplinaSelecionada.getCarga_horaria()+"");
			ckAtiva.setSelected(disciplinaSelecionada.isAtiva());
		}
	}
	
	@FXML
	public void filtrar() {
		String filtro = txtFiltro.getText();
		if (filtro.equals("")) {
			exibirDisciplinas();
		}
		else {
			ArrayList<Disciplina> filtradas = DisciplinaDao.filtra(filtro);
			tbl.setItems(FXCollections.observableArrayList(filtradas));
		}
	}
	
	public void limpaTela() {
		txtNome.setText("");
		txtCargaHoraria.setText("");
		ckAtiva.setSelected(false);
		disciplinaSelecionada = null;
	}

}
