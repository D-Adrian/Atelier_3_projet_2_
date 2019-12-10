package com.company.guijava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args)  {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.10.7:3306/BaseDeDonnee", "Eddy", "shayze7895");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected to Database");

    }
}
