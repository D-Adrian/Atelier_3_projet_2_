package com.company.guijava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
    public Connection connect() {
        {
            try {
                //Connection connection =DriverManager.getConnection("jdbc:mysql://192.168.64.2/BaseDeDonnee", "Eddy" , "shayze7895");
                Connection connection =DriverManager.getConnection("jdbc:mysql://10.0.3.158:3306/BaseDeDonnee", "Eddy" , "shayze7895");

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
