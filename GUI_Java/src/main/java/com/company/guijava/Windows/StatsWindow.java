package com.company.guijava.Windows;

import javax.swing.*;

public class StatsWindow extends JFrame {

    public StatsWindow() {

        JFrame sw = new JFrame("Stats Info");


        ImageIcon icon = new ImageIcon("imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

    }
}
