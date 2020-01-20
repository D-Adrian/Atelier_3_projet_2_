package com.company.guijava;

import javax.swing.*;

public class StatsWindow extends JFrame {

    public StatsWindow() {

        JFrame sw = new JFrame("Stats Info");


        ImageIcon icon = new ImageIcon("GUI_Java/imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        JLabel Topcouleur = new JLabel("Top 3 des couleurs les plus utilisées:");
        Topcouleur.setBounds(20, 20, 300, 30);
        JLabel couleurs = new JLabel("rouge, violet, orange");
        couleurs.setBounds(270, 20, 200, 30);

        JLabel NbProjet = new JLabel("Nombre de projet crée :");
        NbProjet.setBounds(20, 95, 300, 30);
        JLabel Projet = new JLabel("69420");
        Projet.setBounds(270, 95, 200, 30);

        JLabel TotalGainMois = new JLabel("Gain par mois :");
        TotalGainMois.setBounds(20, 170, 300, 30);
        JLabel GainMois = new JLabel("100 000");
        GainMois.setBounds(270, 170, 200, 30);

        this.setVisible(true);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        add(Topcouleur);
        add(couleurs);
        add(NbProjet);
        add(Projet);
        add(TotalGainMois);
        add(GainMois);


    }
}
