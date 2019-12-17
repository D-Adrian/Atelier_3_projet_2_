package com.company.guijava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
    public void connect(String text, String value) {
        {
            try {
                DriverManager.getConnection("jdbc:mysql://192.168.43.254:3306/BaseDeDonnee", text, value);
                System.out.println("Connected to Database");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error");
            }
        }
    }
}
