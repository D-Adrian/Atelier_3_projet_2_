package com.company.guijava;
import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        JFrame db = new JFrame("Stats Info");


        ImageIcon icon = new ImageIcon("GUI_Java/imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


    }
}

