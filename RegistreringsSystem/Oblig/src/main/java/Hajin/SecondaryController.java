package Hajin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static Hajin.PrimaryController.*;
/*
public class SecondaryController implements Initializable {
/*
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> navnKolonne;
    @FXML
    private TableColumn<Person, String> fodselsdatoKolonne;
    @FXML
    private TableColumn<Person, Integer> alderKolonne;
    @FXML
    private TableColumn<Person, String> epostKolonne;
    @FXML
    private TableColumn<Person, String> telefonnrKolonne;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private Button secondaryButton;

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        navnKolonne.setCellValueFactory(new PropertyValueFactory<Person, String>("navn"));
        fodselsdatoKolonne.setCellValueFactory(new PropertyValueFactory<Person, String>("fodselsdato"));
        alderKolonne.setCellValueFactory(new PropertyValueFactory<Person, Integer>("alder"));
        epostKolonne.setCellValueFactory(new PropertyValueFactory<Person, String>("epost"));
        telefonnrKolonne.setCellValueFactory(new PropertyValueFactory<Person, String>("telefonnr"));
    }
}
*/