package com.company.guijava;

import javax.swing.*;
import java.awt.*;

public class EcranConfig extends JFrame
{
    public EcranConfig()
    {
        JFrame frame = new JFrame("Produits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setVisible(true);

    }




}
