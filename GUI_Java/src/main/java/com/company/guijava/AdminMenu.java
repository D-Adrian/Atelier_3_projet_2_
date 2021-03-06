package com.company.guijava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {

    public AdminMenu() {

        JFrame am = new JFrame("Admin Menu");

        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.blue); // NON FONCTIONNEL SUR MacOS
        this.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");

        menu.add("Dashboard").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE STATS

                Dashboard d = new Dashboard();
            }
        });

        menu.add("Stats").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE STATS

                StatsWindow sw = new StatsWindow();
            }
        });

        menu.add("Devis").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE STATS

                DevisWindow sw = new DevisWindow();
            }
        });
        menuBar.add(menu);

        ImageIcon icon = new ImageIcon("GUI_Java/imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.add(menuBar);
    }
}
