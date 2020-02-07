package com.company.guijava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {

    /**
     * La méthode permet de se connecter à la database
     * @return : retourne connexion si possible ou rien si connexion impossible
     */

    public Connection connect() {
        {
            try {
                Connection connection =DriverManager.getConnection("jdbc:mysql://10.0.1.195:3306/BaseDeDonnee", "Eddy" , "shayze7895");

                System.out.println("Connected to Database");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error");
                return null;
            }
        }
    }
}
