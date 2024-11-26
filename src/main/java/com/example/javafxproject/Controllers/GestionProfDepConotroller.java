package com.example.javafxproject.Controllers;

import com.example.javafxproject.Metiers.MetierImpl;
import com.example.javafxproject.Modules.Departement;
import com.example.javafxproject.Modules.Professeur;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GestionProfDepConotroller {
    @FXML
    private TextField textSearch;
    @FXML
    private TableView<Professeur> tableShowProf;
    @FXML
    private TableView<Departement> tableShowDep;
    @FXML
    private TableColumn<Professeur,Integer> idProfShow;
    @FXML
    private TableColumn<Professeur,String> nomProfShow;
    @FXML
    private TableColumn<Professeur,String> prenomProfShow;
    @FXML
    private TableColumn<Professeur,String> cinProfShow;
    @FXML
    private TableColumn<Professeur,String> teleProfShow;
    @FXML
    private TableColumn<Professeur,String> emailProfShow;
    @FXML
    private TableColumn<Professeur,Date> dateProfShow;
    @FXML
    private TableColumn<Professeur,String> depProfShow;
    @FXML
    private TableColumn<Departement,Integer> idDepShow;
    @FXML
    private TableColumn<Departement,String> nomDepShow;

    private MetierImpl metier;

    @FXML
    private void initialize() {
        metier = new MetierImpl();
        // Charger la liste des professeurs et des départements dans les tables
        tableShowProf.getItems().setAll(metier.listerProfesseurs());
        tableShowDep.getItems().setAll(metier.listerDepartements());

        // Configurer les colonnes des tables pour afficher les informations des professeurs
        idProfShow.setCellValueFactory(new PropertyValueFactory<>("id_prof"));
        nomProfShow.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomProfShow.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cinProfShow.setCellValueFactory(new PropertyValueFactory<>("cin"));
        teleProfShow.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        emailProfShow.setCellValueFactory(new PropertyValueFactory<>("email"));
        dateProfShow.setCellValueFactory(new PropertyValueFactory<>("dateRecrutement"));
        //Afficher le nom et non pas l'id
        depProfShow.setCellValueFactory(cellData -> new SimpleStringProperty(
                metier.listerDepartements().stream()
                        .filter(departement -> departement.getId_depart() == cellData.getValue().getId_depart())
                        .map(Departement::getNom)
                        .findFirst()
                        .orElse("Non trouvé")
        ));
        // Configurer les colonnes de la table des départements
        idDepShow.setCellValueFactory(new PropertyValueFactory<>("id_depart"));
        nomDepShow.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        // Charger les données initiales
        rafraichirTables();
    }
    private void rafraichirTables() {
        tableShowProf.getItems().setAll(metier.listerProfesseurs());
        tableShowDep.getItems().setAll(metier.listerDepartements());
    }

    public void ajouterDep(ActionEvent actionEvent) {
        Departement newDep = Dialogue.ajouterDepartementDialog();
        if (newDep != null) {
            metier.ajouterDepartement(newDep);
            rafraichirTables();
        }
    }

    public void supprimerDep(ActionEvent actionEvent) {
        Departement selectedDep = tableShowDep.getSelectionModel().getSelectedItem();
        if (selectedDep != null) {
            metier.supprimerDepartement(selectedDep.getId_depart());
            rafraichirTables();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner un département à supprimer.");
            alert.showAndWait();
        }
    }

    public void profDep(ActionEvent actionEvent) {
        Departement selectedDep = tableShowDep.getSelectionModel().getSelectedItem();
        if (selectedDep != null) {
            tableShowProf.getItems().setAll(metier.professeurParDepartement(selectedDep.getId_depart()));
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner un département pour voir ses professeurs.");
            alert.showAndWait();
        }
    }

    public void rechercherProf(ActionEvent actionEvent) {
        String motCle = textSearch.getText();
        tableShowProf.getItems().setAll(metier.rechercherProfesseurParMotCle(motCle));
        if (motCle==null) rafraichirTables();
    }

    public void ajouterProf(ActionEvent actionEvent) {
        Professeur newProf = Dialogue.ajouterProfesseurDialog();
        if (newProf != null) {
            metier.ajouterProfesseur(newProf);
            rafraichirTables();
        }
    }

    public void supprimerProf(ActionEvent actionEvent) {
        Professeur selectedProf = tableShowProf.getSelectionModel().getSelectedItem();
        if (selectedProf != null) {
            metier.supprimerProfesseur(selectedProf.getId_prof());
            rafraichirTables();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner un professeur à supprimer.");
            alert.showAndWait();
        }
    }

    public void modifierProf(ActionEvent actionEvent) {
        Professeur selectedProf = tableShowProf.getSelectionModel().getSelectedItem();
        if (selectedProf != null) {
            Professeur result = Dialogue.modifierProfesseurDialog(selectedProf);
            if (result != null) {
                metier.modifierProfesseur(selectedProf);
                rafraichirTables();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner un professeur à modifier.");
            alert.showAndWait();
        }
    }
}