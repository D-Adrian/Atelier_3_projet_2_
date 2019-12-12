package com.company.guijava;

import javax.swing.*;
import java.sql.*;

public class App {

    private static Object JFrame;

    public static void main(String[] args) {

        Connexion connexion = new Connexion();
        Gui window = new Gui();



        System.out.println("try ");
        String request = "SELECT id FROM utilisateur";


            try {
                Statement statement = connexion.connect().createStatement();
                ResultSet results = statement.executeQuery(request);
                int id = results.getInt("id");
                System.out.println(id);
                System.out.println(results);
            } catch (SQLException e) {
                //traitement de l'exception
            }





    }
}
