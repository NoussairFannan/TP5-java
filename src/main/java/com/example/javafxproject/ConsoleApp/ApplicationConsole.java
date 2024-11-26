package com.example.javafxproject.ConsoleApp;

import com.example.javafxproject.Metiers.MetierImpl;
import com.example.javafxproject.Modules.Departement;
import com.example.javafxproject.Modules.Professeur;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ApplicationConsole {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n*** Menu Principal ***");
            System.out.println("1. Ajouter un professeur");
            System.out.println("2. Supprimer un professeur");
            System.out.println("3. Modifier un professeur");
            System.out.println("4. Lister tous les professeurs");
            System.out.println("5. Rechercher un professeur par mot clé");
            System.out.println("6. Ajouter un département");
            System.out.println("7. Supprimer un département");
            System.out.println("8. Lister tous les départements");
            System.out.println("9. Lister les professeurs d'un département");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    Professeur professeur = new Professeur();
                    System.out.print("Nom : ");
                    professeur.setNom(scanner.nextLine());
                    System.out.print("Prénom : ");
                    professeur.setPrenom(scanner.nextLine());
                    System.out.print("CIN : ");
                    professeur.setCin(scanner.nextLine());
                    System.out.print("Adresse : ");
                    professeur.setAdresse(scanner.nextLine());
                    System.out.print("Téléphone : ");
                    professeur.setTelephone(scanner.nextLine());
                    System.out.print("Email : ");
                    professeur.setEmail(scanner.nextLine());
                    System.out.print("Date de recrutement (YYYY-MM-DD) : ");
                    professeur.setDateRecrutement(Date.valueOf(scanner.nextLine()));
                    System.out.print("ID du département : ");
                    professeur.setId_depart(scanner.nextInt());
                    scanner.nextLine();
                    metier.ajouterProfesseur(professeur);
                    System.out.println("Professeur ajouté avec succès !");
                    break;

                case 2:
                    System.out.print("ID du professeur à supprimer : ");
                    int idProf = scanner.nextInt();
                    scanner.nextLine();
                    metier.supprimerProfesseur(idProf);
                    System.out.println("Professeur supprimé avec succès !");
                    break;

                case 3:
                    Professeur profModif = new Professeur();
                    System.out.print("ID du professeur à modifier : ");
                    profModif.setId_prof(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nom : ");
                    profModif.setNom(scanner.nextLine());
                    System.out.print("Prénom : ");
                    profModif.setPrenom(scanner.nextLine());
                    System.out.print("CIN : ");
                    profModif.setCin(scanner.nextLine());
                    System.out.print("Adresse : ");
                    profModif.setAdresse(scanner.nextLine());
                    System.out.print("Téléphone : ");
                    profModif.setTelephone(scanner.nextLine());
                    System.out.print("Email : ");
                    profModif.setEmail(scanner.nextLine());
                    System.out.print("Date de recrutement (YYYY-MM-DD) : ");
                    profModif.setDateRecrutement(Date.valueOf(scanner.nextLine()));
                    System.out.print("ID du département : ");
                    profModif.setId_depart(scanner.nextInt());
                    scanner.nextLine();
                    metier.modifierProfesseur(profModif);
                    System.out.println("Professeur modifié avec succès !");
                    break;

                case 4:
                    List<Professeur> professeurs = metier.listerProfesseurs();
                    System.out.println("Liste des professeurs :");
                    for (Professeur p : professeurs) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.print("Mot clé : ");
                    String motCle = scanner.nextLine();
                    List<Professeur> resultats = metier.rechercherProfesseurParMotCle(motCle);
                    System.out.println("Professeurs trouvés :");
                    for (Professeur p : resultats) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    Departement departement = new Departement();
                    System.out.print("Nom du département : ");
                    departement.setNom(scanner.nextLine());
                    metier.ajouterDepartement(departement);
                    System.out.println("Département ajouté avec succès !");
                    break;

                case 7:
                    System.out.print("ID du département à supprimer : ");
                    int idDepart = scanner.nextInt();
                    scanner.nextLine();
                    metier.supprimerDepartement(idDepart);
                    System.out.println("Département supprimé avec succès !");
                    break;

                case 8:
                    List<Departement> departements = metier.listerDepartements();
                    System.out.println("Liste des départements :");
                    for (Departement d : departements) {
                        System.out.println(d);
                    }
                    break;

                case 9:
                    System.out.print("ID du département : ");
                    int depId = scanner.nextInt();
                    scanner.nextLine();
                    List<Professeur> profsParDep = metier.professeurParDepartement(depId);
                    System.out.println("Professeurs du département :");
                    for (Professeur p : profsParDep) {
                        System.out.println(p);
                    }
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        scanner.close();
    }
}

