package com.company.guijava;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

public static void window(String[] jFrame){

    Gui window = new Gui();

        window.setTitle("Graphical User Interfaces"); // Donne un titre à notre fenêtre
        window.setSize(800,500); // Permet de définir la taille (400 large, 100 hauteur)
        window.setLocationRelativeTo(null); // Affiche la fenetre au centre de l'écran
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge
        window.setResizable(false); // autoriser la redimension de la fenetre (non)
        window.setAlwaysOnTop(false); // Garder la fenêtre au premier plan (non)
        window.setVisible(true); // afficher la fenetre (oui)

        // creation objet pan
        JPanel pan = new JPanel();
        // couleur de fond
        pan.setBackground(Color.GRAY);
        // liée notre panel avec notre fenetre
        window.setContentPane(pan);
        window.setVisible(true); // l'afficher




    }
}
