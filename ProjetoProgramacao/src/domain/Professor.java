package domain;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

public class Professor {

    private StringProperty nome;
    private StringProperty email;
    private StringProperty telefone;
    private StringProperty sexo;
    private BooleanProperty ativo;

    public boolean isAtivo() {
        return ativo.get();
    }

    public BooleanProperty ativoProperty() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo.set(ativo);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public String getSexo() {
        return sexo.get();
    }

    public StringProperty sexoProperty() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
