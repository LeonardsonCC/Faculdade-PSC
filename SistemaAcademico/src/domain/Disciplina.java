package domain;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Disciplina {
	private IntegerProperty id = new SimpleIntegerProperty(0);
	private StringProperty nome = new SimpleStringProperty();
	private IntegerProperty carga_horaria = new SimpleIntegerProperty();
	private BooleanProperty ativa = new SimpleBooleanProperty();

	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final IntegerProperty carga_horariaProperty() {
		return this.carga_horaria;
	}
	
	public final int getCarga_horaria() {
		return this.carga_horariaProperty().get();
	}
	
	public final void setCarga_horaria(final int carga_horaria) {
		this.carga_horariaProperty().set(carga_horaria);
	}
	
	public final BooleanProperty ativaProperty() {
		return this.ativa;
	}
	
	public final boolean isAtiva() {
		return this.ativaProperty().get();
	}
	
	public final void setAtiva(final boolean tipo) {
		this.ativaProperty().set(tipo);
	}
	
}
