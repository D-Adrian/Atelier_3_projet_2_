package com.company.guijava.Windows;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PopupCreation extends JFrame {

    public PopupCreation() {

        int TIME_VISIBLE = 3000;


        JLabel jp = new JLabel();
        jp.setText(" Compte crée avec Succès ! ");
        Border margin = new EmptyBorder(10, 13, 5, 10);
        jp.setBorder(margin);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setSize(200, 110);
        this.add(jp);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }


}
