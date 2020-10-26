package application;

import domain.Aluno;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class TabAlunoController {

    @FXML private RadioButton rdFemino;
    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEmail;
    @FXML private ToggleGroup rdSexo;
    @FXML private CheckBox ckAtivo;
    @FXML private RadioButton rdMasculino;
    @FXML private TextField txtFiltro;
    @FXML private TextField txtNascimento;
    @FXML private TableView<Aluno> tbl;
    @FXML private TableColumn<Aluno, String> colEmail;
    @FXML private TableColumn<Aluno, String> colNome;
    @FXML private TableColumn<Aluno, String> colTelefone;

    private ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        colTelefone.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
    }

    @FXML
    public void gravar() {
        Aluno a = new Aluno();
        a.setNome(txtNome.getText());
        a.setEmail(txtEmail.getText());
        a.setTelefone(txtTelefone.getText());
        a.setSexo(rdFemino.isSelected() ? "F" : "M");
        a.setAtivo(ckAtivo.isSelected());
        listaAluno.add(a);
        tbl.setItems(FXCollections.observableArrayList(listaAluno));
        limpaTela();
    }

    @FXML
    public void clicouTbl() {
        Aluno a = new Aluno();
        if (a != null) {
            txtNome.setText(a.getNome());
            txtEmail.setText(a.getEmail());
            txtTelefone.setText(a.getTelefone());
            if (a.getSexo() == "M")
                rdMasculino.setSelected(true);
            else
                rdFemino.setSelected(true);
            ckAtivo.setSelected(a.isAtivo());
        }
    }

    @FXML
    public void excluir() {
        Aluno a = tbl.getSelectionModel().getSelectedItem();
        if (a != null) {
            listaAluno.remove(a);
            tbl.setItems(FXCollections.observableArrayList(listaAluno));
        }
        limpaTela();
    }

    @FXML
    public void filtrar() {
        String filtro = txtFiltro.getText().toUpperCase();
        ArrayList<Aluno> filtradas = new ArrayList<Aluno>();
        for(Aluno a: listaAluno) {
            if (a.getNome().toUpperCase().startsWith(filtro)) {
                filtradas.add(a);
            }
        }
        tbl.setItems(FXCollections.observableArrayList(filtradas));
    }

    private void limpaTela() {
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        rdFemino.setSelected(true);
        ckAtivo.setSelected(false);
    }
}
