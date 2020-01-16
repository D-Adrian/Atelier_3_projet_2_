package com.company.guijava;

import javax.swing.*;
import java.awt.*;

public class EditProject extends JFrame {

    public EditProject(){


        JFrame ep = new JFrame("Product Features");

        final JLabel label = new JLabel();
        label.setBounds(190, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        label.setForeground(Color.red);
        label.setText(" Choose an Option ! ");

        JButton b = new JButton("New Product");
        b.setBounds(150, 140, 160, 60);

        JButton c = new JButton("Edit Product");
        c.setBounds(210, 280, 160, 60);

        JButton d = new JButton("Delete a Product");
        d.setBounds(270, 420, 160, 60);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.add(b);
        this.add(c);
        this.add(d);
        this.setVisible(true);






    }



}
