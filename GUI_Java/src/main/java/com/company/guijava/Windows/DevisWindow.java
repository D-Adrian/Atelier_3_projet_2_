package com.company.guijava.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevisWindow extends JFrame {

    public DevisWindow() {

        JFrame frame = new JFrame("Devis information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        this.getContentPane().add(label);
        this.setLayout(null);

        JButton Modifier = new JButton("Modifier");
        Modifier.setBounds(350, 300, 100, 50);
        this.add(Modifier);

        Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DevisModif dm = new DevisModif();

            }
        });

        ImageIcon icon = new ImageIcon("GUI_Java/imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

    }
}
