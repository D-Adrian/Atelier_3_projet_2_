package com.company.guijava.Windows;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PopupErrorConnexion extends JFrame{

    public PopupErrorConnexion() {


        JPanel p = new JPanel();

        JLabel jp = new JLabel();
        jp.setText(" Account not found ! ");
        Border margin = new EmptyBorder(15, 14, 25, 10);
        jp.setBorder(margin);

        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("imgs/computer-icons-warning-sign-icon-design-exclamation-mark.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JPanel panImg= new JPanel(new GridLayout(1, 1));
        JLabel labelimage = new JLabel(imageIcon);
        panImg.add(labelimage);
        panImg.setOpaque(false);

        p.setLayout(new BorderLayout());
        p.add(panImg, BorderLayout.CENTER);
        p.add(jp, BorderLayout.SOUTH);

        this.setSize(160, 140);
        this.add(p);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }
}