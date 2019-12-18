package com.company.guijava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
    public Connection connect(String text, String value) {
        {
            try {
                Connection connection =DriverManager.getConnection("jdbc:mysql://172.20.10.7:3306/BaseDeDonnee", "Eddy" , "shayze7895");
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
