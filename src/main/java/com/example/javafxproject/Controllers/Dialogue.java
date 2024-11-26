package com.example.javafxproject.Controllers;

import com.example.javafxproject.Modules.Departement;
import com.example.javafxproject.Modules.Professeur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Dialogue {

    // Méthode pour ajouter un professeur
    public static Professeur ajouterProfesseurDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Ajouter un Professeur");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Champs de saisie
        TextField tfNom = new TextField();
        TextField tfPrenom = new TextField();
        TextField tfCin = new TextField();
        TextField tfAdresse = new TextField();
        TextField tfTelephone = new TextField();
        TextField tfEmail = new TextField();
        DatePicker dpDateRecrutement = new DatePicker();
        TextField tfDepartementId = new TextField();

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(tfNom, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(tfPrenom, 1, 1);
        grid.add(new Label("CIN:"), 0, 2);
        grid.add(tfCin, 1, 2);
        grid.add(new Label("Adresse:"), 0, 3);
        grid.add(tfAdresse, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(tfTelephone, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(tfEmail, 1, 5);
        grid.add(new Label("Date Recrutement:"), 0, 6);
        grid.add(dpDateRecrutement, 1, 6);
        grid.add(new Label("ID Département:"), 0, 7);
        grid.add(tfDepartementId, 1, 7);

        Button btnOk = new Button("Ajouter");
        Button btnCancel = new Button("Annuler");
        grid.add(btnOk, 0, 8);
        grid.add(btnCancel, 1, 8);

        Scene scene = new Scene(grid);
        dialog.setScene(scene);

        Professeur professeur = new Professeur();

        // Gestion des actions
        btnOk.setOnAction(event -> {
            professeur.setNom(tfNom.getText());
            professeur.setPrenom(tfPrenom.getText());
            professeur.setCin(tfCin.getText());
            professeur.setAdresse(tfAdresse.getText());
            professeur.setTelephone(tfTelephone.getText());
            professeur.setEmail(tfEmail.getText());
            professeur.setDateRecrutement(java.sql.Date.valueOf(dpDateRecrutement.getValue()));
            professeur.setId_depart(Integer.parseInt(tfDepartementId.getText()));
            dialog.close();
        });

        btnCancel.setOnAction(event -> {
            professeur.setId_prof(-1); // Indiquer qu'aucun professeur n'est ajouté
            dialog.close();
        });

        dialog.showAndWait();
        return professeur;
    }

    // Méthode pour modifier un professeur
    public static Professeur modifierProfesseurDialog(Professeur professeur) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Modifier un Professeur");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Champs de saisie avec valeurs existantes
        TextField tfNom = new TextField(professeur.getNom());
        TextField tfPrenom = new TextField(professeur.getPrenom());
        TextField tfCin = new TextField(professeur.getCin());
        TextField tfAdresse = new TextField(professeur.getAdresse());
        TextField tfTelephone = new TextField(professeur.getTelephone());
        TextField tfEmail = new TextField(professeur.getEmail());
        DatePicker dpDateRecrutement = new DatePicker(professeur.getDateRecrutement().toLocalDate());
        TextField tfDepartementId = new TextField(String.valueOf(professeur.getId_depart()));

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(tfNom, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(tfPrenom, 1, 1);
        grid.add(new Label("CIN:"), 0, 2);
        grid.add(tfCin, 1, 2);
        grid.add(new Label("Adresse:"), 0, 3);
        grid.add(tfAdresse, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(tfTelephone, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(tfEmail, 1, 5);
        grid.add(new Label("Date Recrutement:"), 0, 6);
        grid.add(dpDateRecrutement, 1, 6);
        grid.add(new Label("ID Département:"), 0, 7);
        grid.add(tfDepartementId, 1, 7);

        Button btnOk = new Button("Modifier");
        Button btnCancel = new Button("Annuler");
        grid.add(btnOk, 0, 8);
        grid.add(btnCancel, 1, 8);

        Scene scene = new Scene(grid);
        dialog.setScene(scene);

        // Gestion des actions
        btnOk.setOnAction(event -> {
            professeur.setNom(tfNom.getText());
            professeur.setPrenom(tfPrenom.getText());
            professeur.setCin(tfCin.getText());
            professeur.setAdresse(tfAdresse.getText());
            professeur.setTelephone(tfTelephone.getText());
            professeur.setEmail(tfEmail.getText());
            professeur.setDateRecrutement(java.sql.Date.valueOf(dpDateRecrutement.getValue()));
            professeur.setId_depart(Integer.parseInt(tfDepartementId.getText()));
            dialog.close();
        });

        btnCancel.setOnAction(event -> dialog.close());

        dialog.showAndWait();
        return professeur;
    }

    // Méthode pour ajouter un département
    public static Departement ajouterDepartementDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Ajouter un Département");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField tfNom = new TextField();
        grid.add(new Label("Nom Département:"), 0, 0);
        grid.add(tfNom, 1, 0);

        Button btnOk = new Button("Ajouter");
        Button btnCancel = new Button("Annuler");
        grid.add(btnOk, 0, 1);
        grid.add(btnCancel, 1, 1);

        Scene scene = new Scene(grid);
        dialog.setScene(scene);

        Departement departement = new Departement();

        // Gestion des actions
        btnOk.setOnAction(event -> {
            departement.setNom(tfNom.getText());
            dialog.close();
        });

        btnCancel.setOnAction(event -> {
            departement.setId_depart(-1); // Indiquer qu'aucun département n'est ajouté
            dialog.close();
        });

        dialog.showAndWait();
        return departement;
    }
}
