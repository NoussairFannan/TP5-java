package com.example.javafxproject.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexionDB {
    private static Connection connection;

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/gestion_prof_departement";
                String user = "root";
                String password = "test";
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
