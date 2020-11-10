package domain;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	protected IntegerProperty id= new SimpleIntegerProperty();
	protected StringProperty nome = new SimpleStringProperty();
	protected StringProperty nascimento = new SimpleStringProperty();
	protected StringProperty sexo = new SimpleStringProperty();
	protected StringProperty telefone = new SimpleStringProperty();
	protected StringProperty email = new SimpleStringProperty();
	protected StringProperty tipo = new SimpleStringProperty();
	protected BooleanProperty ativa = new SimpleBooleanProperty();

	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final Integer getId() {
		return this.id.get();
	}
	
	public final void setId(final Integer id) {
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
	
	public final StringProperty nascimentoProperty() {
		return this.nascimento;
	}
	
	public final String getNascimento() {
		return this.nascimentoProperty().get();
	}
	
	public final void setNascimento(final String nascimento) {
		this.nascimentoProperty().set(nascimento);
	}
	
	public final StringProperty sexoProperty() {
		return this.sexo;
	}
	
	public final String getSexo() {
		return this.sexoProperty().get();
	}
	
	public final void setSexo(final String sexo) {
		this.sexoProperty().set(sexo);
	}
	
	public final StringProperty telefoneProperty() {
		return this.telefone;
	}
	
	public final String getTelefone() {
		return this.telefoneProperty().get();
	}
	
	public final void setTelefone(final String telefone) {
		this.telefoneProperty().set(telefone);
	}
	
	public final StringProperty emailProperty() {
		return this.email;
	}
	
	public final String getEmail() {
		return this.emailProperty().get();
	}
	
	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	
	public final StringProperty tipoProperty() {
		return this.tipo;
	}
	
	public final String getTipo() {
		return this.tipoProperty().get();
	}
	
	public final void setTipo(final String tipo) {
		this.tipoProperty().set(tipo);
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
