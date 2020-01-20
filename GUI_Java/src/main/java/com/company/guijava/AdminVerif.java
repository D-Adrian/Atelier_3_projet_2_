package com.company.guijava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminVerif extends JFrame{

    public AdminVerif(){

        JFrame af = new JFrame("Verification");

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 75, 80, 10);

        final JPasswordField password = new JPasswordField();
        password.setBounds(100, 70, 100, 20);

        JButton b = new JButton("Login");
        b.setBounds(100, 120, 80, 30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AdminMenu am = new AdminMenu();

            }
        });

        this.setLocationRelativeTo(null);
        this.setSize(250, 210);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(b);
        this.add(l2);
        this.add(password);




    }
}
