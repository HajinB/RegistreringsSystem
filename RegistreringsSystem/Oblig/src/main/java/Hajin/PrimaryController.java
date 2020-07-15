package Hajin;


import Hajin.Avvik.InvalidAgeException;
import Hajin.Avvik.InvalidPersonFormatException;
import Hajin.Filbehandling.FileOpener;
import Hajin.Filbehandling.FileSaver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import static Hajin.PersonValidering.*;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;


public class PrimaryController implements Initializable {

    PersonRegistrering registrering = new PersonRegistrering();

    @FXML
    private TableView<Person> tv;

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtDag;

    @FXML
    private TextField txtMnd;

    @FXML
    private TextField txtAar;

    @FXML
    private TextField txtTelefonnr;

    @FXML
    private TextField txtAlder;

    @FXML
    private TextField txtEpost;

    @FXML
    private Label lblBekreftelse;

    @FXML
    private Label lblBekreftelse2;

    @FXML
    private TableColumn<Person, String> Navn;

    @FXML
    private TableColumn<Person, String> Fodselsdato;

    @FXML
    private TableColumn<Person, Integer> Alder;

    @FXML
    private TableColumn<Person, String> Epost;

    @FXML
    private TableColumn<Person, String> Telefonnr;

    @FXML
    void btnRegistrer() {
        lblBekreftelse.setText(null);
        lblBekreftelse2.setText(null);

        String navn = txtNavn.getText();
        int dag = Integer.parseInt(txtDag.getText());
        int mnd = Integer.parseInt(txtMnd.getText());
        int aar = Integer.parseInt(txtAar.getText());
        int alder = Integer.parseInt(txtAlder.getText());
        String epost = txtEpost.getText();
        String telefonnr = txtTelefonnr.getText();

        DatoNY d = new DatoNY(dag, mnd, aar);
        int detteAar = Calendar.getInstance().get(Calendar.YEAR);

        if (dag < 1 || dag > 31) {
            lblBekreftelse.setText("Dag må være mellom 1-31");
        }
        if (mnd < 1 || mnd > 12) {
            lblBekreftelse.setText("Måned må være mellom 1-12");
        }
        if (aar < 1920 || aar > detteAar) {
            lblBekreftelse.setText("Fødselsår må være mellom 1920 - " + detteAar);
        }

        if (txtNavn.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn navn");
        }
        if (!erNavnGyldig(navn)) {
            lblBekreftelse.setText("Navn er ikke gyldig. Prøv igjen.");
        }
        if (!erTelefonnummerGyldig(telefonnr)) {
            lblBekreftelse.setText("Telefonnummer er ikke gyldig. Prøv igjen.");
        }

        if (!erEpostGyldig(epost)) {
            lblBekreftelse.setText("Epost er ikke gyldig. Prøv igjen.");
        }

        if (txtDag.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn dato");
        }
        if (txtMnd.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn måned");
        }
        if (txtAar.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn år");
        }

        if (txtAlder.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn alder");
        }
        if (txtEpost.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn epost-adresse");
        }
        if (txtTelefonnr.getText().isEmpty()) {
            lblBekreftelse.setText("Du må skrive inn telefonnummeret ditt");
        }

        if (alder > 120 || alder < 0) {
            throw new InvalidAgeException("Alder må være mellom 0-120! Prøv igjen.");
        }
        if (!(erEpostGyldig(epost) && erTelefonnummerGyldig(telefonnr) && erNavnGyldig(navn))) {
            try {
                throw new InvalidPersonFormatException("Noen av dataene er ikke gyldige. Prøv igjen");
            } catch (InvalidPersonFormatException e) {
                e.printStackTrace();
            }
        } else {
            registrering.personreg(navn, d.toString(), alder, epost, telefonnr);
        }
        tv.setItems(registrering.personListe);
        lblBekreftelse2.setText("Registrering vellykket. Sjekk at informasjonen stemmer nedenfor");

        resetTxtFields();
    }

    @FXML
    void btnLagre (ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(    //lager filter før man åpner dialogen og tillater kun txtfiler
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File selectedFile = fileChooser.showSaveDialog(null); //showOPenDialog er å åpne native filechooser!!
        // selected file er den fila man velger.., så man skal kunne bare sende dette objektet til filbehandlingmetode for å få det lagra!

        if (selectedFile != null) {
            //SAVE TO FILE METODE HER
            System.out.println("Lagring vellykket");
            FileSaver.writeString(registrering.toString(), selectedFile.toPath());

            //  filbehandling.FileSaver(personRegister, selectedFile.getAbsolutePath());
        } else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    void btnSeListe (ActionEvent event) throws IOException{
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null); //showOPenDialog er å åpne native filechooser!!
        // selected file
        // er den fila man vil åpne
        //

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        if (selectedFile != null) {
            /*
            open and show file-metode he
            read metoden til Reader returnerer en liste (arraylist) - men vi kan legge til alt ved hjelp av addAll
            */
            registrering.personListe.addAll(FileOpener.readPeople(selectedFile.getPath()));
            lblBekreftelse2.setText("Vellykket åpning av fil");

            //  filbehandling.FileSaver(personRegister, selectedFile.getAbsolutePath());

        } else {
            System.out.println("file is not valid");
        }
    }

    @FXML 
    public void btnSlettInnhold (ActionEvent event) {
        txtNavn.setText(null);
        txtDag.setText(null);
        txtMnd.setText(null);
        txtAlder.setText(null);
        txtAar.setText(null);
        txtEpost.setText(null);
        txtTelefonnr.setText(null);

    }

        /*Person enPerson = opprettPerson();

        resetTxtFields();
        registrering.leggtilPerson(enPerson);
        lblBekreftelse2.setText("Registrering vellykket!");
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registrering.attachTableView(tv);
    }

    private void resetTxtFields() {
        txtNavn.setText("");
        txtDag.setText("");
        txtMnd.setText("");
        txtAlder.setText("");
        txtAar.setText("");
        txtEpost.setText("");
        txtTelefonnr.setText("");
    }
}