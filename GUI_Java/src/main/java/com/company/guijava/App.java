package com.company.guijava;

import javax.swing.*;
import java.sql.*;

public class App {

    private static Object JFrame;

    public static void main(String[] args) {

        Connexion connexion = new Connexion();
        Gui window = new Gui();


/*
        System.out.println("try ");
        String request = "SELECT * FROM client";
        try {
            Statement statement = connexion.connect().createStatement(); ResultSet results = statement.executeQuery(request);
        } catch (SQLException e) {
            //traitement de l'exception
        }

 */





    }
}
