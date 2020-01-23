package com.company.guijava.Windows;

import com.company.guijava.Save.JsonWriterLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame {

    public Gui() {
        super();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JsonWriterLogin writer = new JsonWriterLogin();
                writer.writeInFileSession("", "", "", "src/main/java/com/company/guijava/userSession.json");
                System.exit(0);
            }
        });

        JFrame window = this;
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.blue); // NON FONCTIONNEL SUR MacOS
        window.setJMenuBar(menuBar);
        this.setTitle("Leroy Merlu | Main Menu");

        JMenu menu = new JMenu("Menu");


        menu.add("| Disconnect").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // DECONNEXION

            }
        });

        menu.add("| Dashboard").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE VERIF

                UserWindow uw = new UserWindow();
            }
        });


        menu.add("| Admin").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE VERIF

                AdminVerif af = new AdminVerif(window);
            }
        });

        menu.add("| Exit").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0); //Permet de fermer le processus avec la croix rouge

            }
        });

        menuBar.add(menu);


        //JPanel panneau = new JPanel();
        //panneau.add(bouton);
        //setContentPane(panneau);

        Image icon1 = new javax.swing.ImageIcon("imgs/ez.png").getImage();
        window.setIconImage(icon1);

        ImageIcon icon = new ImageIcon("imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        window.add(logo);

        window.setVisible(true);

    }
}
