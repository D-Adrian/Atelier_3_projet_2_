package com.company.guijava;
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        JFrame frame = new JFrame("DashBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setVisible(true);


        ImageIcon icon = new ImageIcon("GUI_Java/imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


    }
}

