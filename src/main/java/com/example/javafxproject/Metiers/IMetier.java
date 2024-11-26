package com.example.javafxproject.Metiers;

import com.example.javafxproject.Modules.Departement;
import com.example.javafxproject.Modules.Professeur;

import java.util.List;

public interface IMetier {
    // Méthodes pour gérer les professeurs
    void ajouterProfesseur(Professeur professeur);
    void supprimerProfesseur(int id_prof);
    void modifierProfesseur(Professeur professeur);
    List<Professeur> rechercherProfesseurParMotCle(String motCle);
    List<Professeur> listerProfesseurs();

    // Méthodes pour gérer les départements
    void ajouterDepartement(Departement departement);
    void supprimerDepartement(int id_depart);
    List<Departement> listerDepartements();
    List<Professeur> professeurParDepartement(int id_depart);
}

