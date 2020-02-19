package Hajin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Person {

    private SimpleStringProperty navn;
    private SimpleStringProperty fodselsdato;
    private SimpleIntegerProperty alder;
    private SimpleStringProperty epost;
    private SimpleStringProperty telefonnr;

    public Person(String navn, String fodselsdato, int alder, String epost, String telefonnr) {
        this.navn = new SimpleStringProperty(navn);
        this.fodselsdato = new SimpleStringProperty(fodselsdato);
        this.alder = new SimpleIntegerProperty(alder);
        this.epost = new SimpleStringProperty(epost);
        this.telefonnr = new SimpleStringProperty(telefonnr);
    }

    public String getNavn() {
        return navn.get();
    }

    public SimpleStringProperty navnProperty() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public String getFodselsdato() {
        return fodselsdato.get();
    }

    public SimpleStringProperty fodselsdatoProperty() {
        return fodselsdato;
    }

    public void setFodselsdato(String fodselsdato) {
        this.fodselsdato.set(fodselsdato);
    }

    public int getAlder() {
        return alder.get();
    }

    public SimpleIntegerProperty alderProperty() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder.set(alder);
    }

    public String getEpost() {
        return epost.get();
    }

    public SimpleStringProperty epostProperty() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost.set(epost);
    }

    public String getTelefonnr() {
        return telefonnr.get();
    }

    public SimpleStringProperty telefonnrProperty() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr.set(telefonnr);
    }


}
