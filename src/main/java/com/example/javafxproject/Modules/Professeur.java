package com.example.javafxproject.Modules;

import java.util.Date;

public class Professeur {
    private int id_prof;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String telephone;
    private String email;
    private Date dateRecrutement;
    private int id_depart;

    public Professeur(int id_depart, Date dateRecrutement, String email, String telephone, String adresse, String cin, String prenom, String nom, int id_prof) {
        this.id_depart = id_depart;
        this.dateRecrutement = dateRecrutement;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.id_prof = id_prof;
    }

    public Professeur() {}

    public Professeur(int id_prof, Date dateRecrutement, String email, String telephone, String adresse, String cin, String prenom, String nom) {
        this.id_prof = id_prof;
        this.dateRecrutement = dateRecrutement;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
    }



    public int getId_prof() {
        return id_prof;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public java.sql.Date getDateRecrutement() {
        return (java.sql.Date) dateRecrutement;
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "id_prof=" + id_prof +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dateRecrutement=" + dateRecrutement +
                ", id_depart=" + id_depart +
                '}';
    }

}
