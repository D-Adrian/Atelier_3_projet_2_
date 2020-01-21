package com.company.guijava.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevisModif extends JFrame
{
    public DevisModif()
    {
        JFrame mf = new JFrame("Modifier");


        JButton Npayer = new JButton("Non payer");
        Npayer.setBounds(20, 20, 80, 50);

        JButton Payer = new JButton("Payer");
        Payer.setBounds(120, 20, 80, 50);

        JButton Editer = new JButton("Editer");
        Editer.setBounds(220, 20, 80, 50);

        add(Npayer);
        add(Payer);
        add(Editer);
        this.setSize(320, 150);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

}
