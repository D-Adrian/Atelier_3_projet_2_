package com.company.guijava.Windows;

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

        menu.add("Stats").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE STATS

                StatsWindow sw = new StatsWindow();
            }
        });
        menuBar.add(menu);

        ImageIcon icon = new ImageIcon("imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.add(menuBar);
    }
}
