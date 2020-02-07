package com.company.guijava;

import com.company.guijava.Windows.Login;

/**
 * Classe de base permettant la connexion et l'ouverture de la première fenêtre
 */

public class App {

    private static Object JFrame;

    public static void main(String[] args) {

        new Connexion();
        new Login();


    }
}
