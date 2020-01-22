package com.company.guijava.Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {

    public AdminMenu() {

        //JFrame am = new JFrame("Admin Menu");
/*
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        menu.add("Stats").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE STATS

                StatsWindow sw = new StatsWindow();
            }
        });
        menuBar.add(menu);
        setJMenuBar(menuBar);


        Panel pan = new Panel("imgs/Leroy_Merlu.png");
        pan.setVisible(true);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(pan);
        this.setVisible(true);
        this.add(menuBar);
        */


        JFrame window = this;
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Admin");

        menu.add("| Previous").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                Gui g = new Gui();
                window.dispose();
            }
        });

        menu.add("| Stats").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                StatsWindow sw = new StatsWindow();
            }
        });

        JMenu menu2 = new JMenu("Dashboard");
        menu.add("| Dashboard").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                Dashboard db = new Dashboard();
            }
        });

        JMenu menu3 = new JMenu("Devis");
        menu.add("| Devis").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                DevisWindow dw = new DevisWindow();
            }
        });

        menuBar.add(menu);


        ImageIcon icon = new ImageIcon("imgs/admin-logo-png-5.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge
        this.setVisible(true);
    }
}

