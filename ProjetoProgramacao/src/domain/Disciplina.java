package domain;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Disciplina {

	private StringProperty nome = new SimpleStringProperty("");
	private IntegerProperty cargaHoraria = new SimpleIntegerProperty(0);
	private BooleanProperty ativa = new SimpleBooleanProperty(false);
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final IntegerProperty cargaHorariaProperty() {
		return this.cargaHoraria;
	}
	
	public final int getCargaHoraria() {
		return this.cargaHorariaProperty().get();
	}
	
	public final void setCargaHoraria(final int cargaHoraria) {
		this.cargaHorariaProperty().set(cargaHoraria);
	}
	
	public final BooleanProperty ativaProperty() {
		return this.ativa;
	}
	
	public final boolean isAtiva() {
		return this.ativaProperty().get();
	}
	
	public final void setAtiva(final boolean ativa) {
		this.ativaProperty().set(ativa);
	}
	
	
}
