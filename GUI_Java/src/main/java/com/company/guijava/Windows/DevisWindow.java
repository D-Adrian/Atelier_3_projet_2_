package com.company.guijava.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevisWindow extends JFrame {

    public DevisWindow() {

        JFrame frame = new JFrame("Devis Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        this.getContentPane().add(label);
        this.setLayout(null);

        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

    }
}
