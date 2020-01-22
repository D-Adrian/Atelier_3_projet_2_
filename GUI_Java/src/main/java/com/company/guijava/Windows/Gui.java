package com.company.guijava.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame {

    public Gui() {

        JFrame window = new JFrame("Leroy Merlu");
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.blue); // NON FONCTIONNEL SUR MacOS
        window.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        //menu.add("SignUp");
        menu.add("| Signup").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                AccountCreation acc = new AccountCreation();
            }
        });

        menu.add("| Login").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE CONNEXION

                Login login = new Login();
            }
        });

        menu.add("| Admin").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE VERIF

                AdminVerif af = new AdminVerif(window);
            }
        });

        menu.add("| Exit").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0); //Permet de fermer le processus avec la croix rouge

            }
        });

        menuBar.add(menu);


        //JPanel panneau = new JPanel();
        //panneau.add(bouton);
        //setContentPane(panneau);

        Image icon1 = new javax.swing.ImageIcon("imgs/ez.png").getImage();
        window.setIconImage(icon1);

        ImageIcon icon = new ImageIcon("imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        window.add(logo);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge
        window.setVisible(true);

        Login login = new Login();

    }
}
