package Hajin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class PersonRegistrering {
    public ObservableList<Person> personListe = FXCollections.observableArrayList();

    public void personreg(String navn, String fodselsdato, int alder, String epost, String telefonnr) {
        Person nyPerson = new Person(navn, fodselsdato, alder, epost, telefonnr);
        personListe.add(nyPerson);
        System.out.println(navn + " er registrert");
    }

    @Override
    public String toString() {
        StringBuilder melding = new StringBuilder();

        for (Person enPerson : personListe) {
            melding.append(enPerson.getNavn()).append(";").append(enPerson.getFodselsdato()).append(";").append(enPerson.getAlder())
                    .append(";").append(enPerson.
                    getEpost()).append(";").append(enPerson.getTelefonnr()).append("\n");
        }
        return melding.toString();
    }

    public void attachTableView(TableView<Person> tv) {
        if (!personListe.isEmpty())
            tv.setItems(personListe);
    }
}