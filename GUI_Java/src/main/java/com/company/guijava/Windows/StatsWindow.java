package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StatsWindow extends JFrame {

    public StatsWindow() {

        JFrame sw = new JFrame("Stats Info");


        ImageIcon icon = new ImageIcon("GUI_Java/imgs/Leroy_Merlu.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        this.add(logo);

        JPanel labelPan = new JPanel();
        labelPan.setLayout(new BorderLayout());
        List<String> values = new Request().favoriteColor();
        JLabel couleurs = new JLabel("        Top 3 des couleurs les plus utilisées: " + values.get(1)+ ", " + values.get(3) + ", " + values.get(5));
        labelPan.add(couleurs, BorderLayout.CENTER);

        List<String> valuesProject = new Request().nbProject();
        JLabel Projet = new JLabel("        Nombre de projet crée : " + valuesProject.get(0));
        labelPan.add(Projet, BorderLayout.NORTH);

        List<String> valuesGain = new Request().gainTotal();


        JPanel buttonPan = new JPanel();

        JButton buttonGain = new JButton("Gain par Mois");
        buttonPan.add(buttonGain);

        buttonGain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GainWindow gw = new GainWindow();

            }
        });











        this.setVisible(true);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setTitle("Stats");
        this.add(buttonPan, BorderLayout.SOUTH);
        this.add(labelPan, BorderLayout.CENTER);
        //add(couleurs);
        //add(Projet);

    }
}