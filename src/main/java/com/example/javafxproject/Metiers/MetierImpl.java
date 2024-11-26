package com.example.javafxproject.Metiers;

import com.example.javafxproject.Modules.Departement;
import com.example.javafxproject.Modules.Professeur;
import com.example.javafxproject.Singleton.SingletonConnexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier{
    private Connection connection = SingletonConnexionDB.getConnexion();
    @Override
    public void ajouterProfesseur(Professeur professeur) {
        try {
            String query = "INSERT INTO professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement, departement_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, professeur.getDateRecrutement());
            ps.setInt(8, professeur.getId_depart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerProfesseur(int id_prof) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM professeurs WHERE id = ?");
            ps.setInt(1, id_prof);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifierProfesseur(Professeur professeur) {
        try {
            String query = "UPDATE professeur SET nom=?, prenom=?, cin=?, adresse=?, telephone=?, email=?, date_recrutement=?, departement_id=? WHERE id_prof=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, professeur.getDateRecrutement());
            ps.setInt(8, professeur.getId_depart());
            ps.setInt(9, professeur.getId_prof());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> rechercherProfesseurParMotCle(String motCle) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM professeur WHERE nom LIKE ? OR prenom LIKE ? OR cin LIKE ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + motCle + "%");
            ps.setString(2, "%" + motCle + "%");
            ps.setString(3, "%" + motCle + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId_prof(rs.getInt("id_prof"));
                professeur.setNom(rs.getString("nom"));
                professeur.setPrenom(rs.getString("prenom"));
                professeur.setCin(rs.getString("cin"));
                professeur.setAdresse(rs.getString("adresse"));
                professeur.setTelephone(rs.getString("telephone"));
                professeur.setEmail(rs.getString("email"));
                professeur.setDateRecrutement(rs.getDate("date_recrutement"));
                professeur.setId_depart(rs.getInt("departement_id"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Professeur";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Professeur p = new Professeur();
                p.setId_prof(rs.getInt("id_prof"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setAdresse(rs.getString("adresse"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDateRecrutement(rs.getDate("date_recrutement"));
                p.setId_depart(rs.getInt("id_depart"));
                professeurs.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void ajouterDepartement(Departement departement) {
        try {
            String query = "INSERT INTO departement (nom) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, departement.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerDepartement(int id_depart) {
        try {
            String query = "DELETE FROM departement WHERE id_deprat=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_depart);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Departement> listerDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String query = "SELECT * FROM departement";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Departement departement = new Departement();
                departement.setId_depart(rs.getInt("id_deprat"));
                departement.setNom(rs.getString("nom"));
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public List<Professeur> professeurParDepartement(int id_depart) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM professeur WHERE id_deprat=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_depart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professeur p = new Professeur();
                p.setId_prof(rs.getInt("id_prof"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setAdresse(rs.getString("adresse"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDateRecrutement(rs.getDate("date_recrutement"));
                p.setId_depart(rs.getInt("id_depart"));
                professeurs.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }
}
