package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class PrincipalController {
	@FXML
	TabPane tabPane;

	@FXML
	public void abreTelaDisciplinas() {
		abreTab("Disciplinas", "CadastroDisciplina.fxml");
	}

	@FXML
	public void abreTelaProfessores() {
		abreTab("Professores", "CadastroProfessor.fxml");
	}
	
	@FXML
	public void abreTelaAlunos() {
		abreTab("Alunos", "CadastroAluno.fxml");
	}

	 private void abreTab(String titulo, String path) {
				try{
					Tab tab = tabAberta(titulo);
					if (tab==null) {
						tab = new Tab(titulo);
						tab.setClosable(true);
						tabPane.getTabs().add(tab);
						FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
						Parent root = loader.load();
						tab.setContent((Node) root);
					}
					selecionaTab(tab);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	
	private Tab tabAberta(String titulo) {
		for (Tab tb : tabPane.getTabs()) {
			if(!(tb.getText()==null) && tb.getText().equals(titulo)) 
				return tb;
		}
		return null;
	}
	
	
	private void selecionaTab(Tab tab) {
		tabPane.getSelectionModel().select(tab);
	}
}
