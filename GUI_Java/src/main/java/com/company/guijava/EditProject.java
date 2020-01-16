package com.company.guijava;

import javax.swing.*;
import java.awt.*;

public class EditProject extends JFrame {

    public EditProject(){


        JFrame ep = new JFrame("Product Features");

        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        label.setForeground(Color.red);
        label.setText(" Project List ");

        JButton b = new JButton("Add Product");
        b.setBounds(20, 500, 160, 60);

        JButton c = new JButton("Edit Product");
        c.setBounds(220, 500, 160, 60);

        JButton d = new JButton("Delete Product");
        d.setBounds(420, 500, 160, 60);

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
