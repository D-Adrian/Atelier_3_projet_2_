package com.company.guijava;

import javax.swing.*;

public class UserWindow extends JFrame{

    public UserWindow() {

        JFrame uw = new JFrame("Profil");

        final JLabel label = new JLabel();
        label.setBounds(200, 10, 200, 200);
        label.setText(" Choose an Option ! ");

        JButton b = new JButton("New Project");
        b.setBounds(150, 140, 160, 60);

        JButton c = new JButton("Edit Project");
        c.setBounds(210, 280, 160, 60);

        JButton d = new JButton("End a Project");
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
