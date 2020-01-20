package com.company.guijava;

import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import java.awt.*;


public class NewProject extends JFrame
{
    public NewProject()
    {
        JFrame frame = new JFrame("Produits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setVisible(true);

        JButton Validate = new JButton("Validate");
        Validate.setBounds(350, 300, 100, 50);
        this.add(Validate);

        final JTextField NomProjet = new JTextField();
        NomProjet.setBounds(135, 20, 350, 30);

        final JTextField Description = new JTextField();
        Description.setBounds(135, 75, 350, 150);



        JLabel np = new JLabel("Nom du Projet:");
        np.setBounds(20, 20, 100, 30);
        JLabel desc = new JLabel("Description:");
        desc.setBounds(20, 75, 100, 30);

        add(np);
        add(desc);
        add(NomProjet);
        add(Description);


    }




}
