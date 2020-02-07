package com.company.guijava.Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * La classe permet de crée un menu admin différent du menu utilisateur
 */

public class AdminMenu extends JFrame {

    public AdminMenu() {

        JFrame window = this;
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Admin");

        menu.add("| Disconnect").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // DECONNEXION

                new Login();
                window.dispose();
            }
        });

        menu.add("| User Menu").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                new Gui();
                window.dispose();
            }
        });

        menu.add("| Stats").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                new StatsWindow();
            }
        });

        menu.add("| Dashboard").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

               new Dashboard();
            }
        });

        menu.add("| Devis").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                new DevisWindowAdmin();
            }
        });

        menuBar.add(menu);


        ImageIcon icon = new ImageIcon("imgs/admin-logo-png-5.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);
        this.setTitle("Leroy Merlu | Admin Menu");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge
        this.setVisible(true);
    }
}


