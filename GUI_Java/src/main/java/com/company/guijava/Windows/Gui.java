package com.company.guijava.Windows;

import com.company.guijava.Save.JSonReader;
import com.company.guijava.Save.JsonWriterLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class Gui extends JFrame {

    /**
     * La méthode affiche la première fenêtre de l'application après la connexion (user menu)
     */

    public Gui() {
        super();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JsonWriterLogin writer = new JsonWriterLogin();
                writer.writeInFileSession("", "", "", "", "src/main/java/com/company/guijava/userSession.json");
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

                Login l = new Login();
                window.dispose();
            }
        });

        try{
            //lecture json session
            //recupere les droits (user ou admin)
            List<String> userSession = new JSonReader().readFileLoginSession("src/main/java/com/company/guijava/userSession.json");
            if(userSession.get(3).toLowerCase().equals("admin")) {
                menu.add("| Admin Menu").addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new AdminMenu();
                        window.dispose();
                    }
                });
            }
        }catch (Exception e){
        }

        menu.add("| Dashboard").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE Dashboard

                new DashboardUser();
            }
        });

        menu.add("| Devis").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE DE Devis

                new DevisWindowUser();
            }
        });

        menu.add("| Exit").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0); //Permet de fermer le processus avec la croix rouge

            }
        });

        menuBar.add(menu);

        Image icon1 = new javax.swing.ImageIcon("imgs/ez.png").getImage();
        window.setIconImage(icon1);

        ImageIcon icon = new ImageIcon("imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        window.add(logo);

        window.setVisible(true);

    }
}
