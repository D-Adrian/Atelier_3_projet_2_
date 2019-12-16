package com.company.guijava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame {

    public Gui() {


        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);

        JFrame window = new JFrame("Graphical User Interface");
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        //JButton bouton = new JButton("Mon bouton");
        //bouton.setSize(20,10);

        JTextArea textArea1 = new JTextArea("WELCOME");
        window.add(textArea1);
        //window.getContentPane().add(bouton);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.orange); // NON FONCTIONNEL
        window.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        //menu.add("SignUp");
        menu.add("SignUp").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                UserAccountCreation but = new UserAccountCreation();
            }
        });


        menu.add("Login").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE CONNEXION

                Login login = new Login();
            }
        });

        menu.add("Exit").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge

            }
        });


        menuBar.add(menu);


        //JPanel panneau = new JPanel();
        //panneau.add(bouton);
        //setContentPane(panneau);

        ImageIcon img = new ImageIcon("imgs/ez.png");
        JLabel petitLogo = new JLabel("", img, JLabel.CENTER); // NON FONCTIONNEL
        window.setIconImage(getIconImage());
        window.add(petitLogo);

        ImageIcon icon = new ImageIcon("imgs/database-icon.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        window.add(logo);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge
        window.setVisible(true);
    }

    /**Gui window = new Gui();

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
     // l'afficher
     window.setVisible(true); */


}
