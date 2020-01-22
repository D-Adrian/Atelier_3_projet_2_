package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreation extends JFrame {

    public AccountCreation() {

        /** CREATION DE LA FENETRE "acc" */


        JFrame acc = new JFrame("Account Creation");


        /** CREATION DU Label "label" */


        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);


        /** CASE AVEC VALEUR */


        final JTextField nom = new JTextField();
        nom.setBounds(195, 20, 100, 30);

        final JTextField prenom = new JTextField();
        prenom.setBounds(195, 75, 100, 30);

        final JTextField mail = new JTextField();
        mail.setBounds(195, 130, 100, 30);

        final JPasswordField password = new JPasswordField();
        password.setBounds(195, 185, 100, 30);

        final JTextField numero = new JTextField();
        numero.setBounds(195, 240, 100, 30);

        final JTextField adresse = new JTextField();
        adresse.setBounds(195, 295, 100, 30);

        final JTextField postal = new JTextField();
        postal.setBounds(195, 350, 100, 30);

        final JTextField siege = new JTextField();
        siege.setBounds(195, 405, 100, 30);

        final JTextField distance = new JTextField();
        distance.setBounds(195, 460, 100, 30);



        /** AJOUTE TOUTES LES ZONES DE TEXTE AINSI QUE LEURS POSITIONS */

        JPanel pannel = new JPanel();
        pannel.setBounds(5, 530, 600, 40);

        JLabel l1 = new JLabel("nom :");
        l1.setBounds(20, 20, 80, 30);
        JLabel l2 = new JLabel("prenom :");
        l2.setBounds(20, 75, 80, 30);
        JLabel l3 = new JLabel("mail :");
        l3.setBounds(20, 130, 80, 30);
        JLabel l4 = new JLabel("password :");
        l4.setBounds(20, 185, 80, 30);
        JLabel l5 = new JLabel("numero portable :");
        l5.setBounds(20, 240, 150, 30);
        JLabel l6 = new JLabel("adresse postale :");
        l6.setBounds(20, 295, 150, 30);
        JLabel l7 = new JLabel("code postal :");
        l7.setBounds(20, 350, 150, 30);
        JLabel l8 = new JLabel("siège le plus proche (ville) :");
        l8.setBounds(20, 405, 190, 30);
        JLabel l9 = new JLabel("distance estime (en km) :");
        l9.setBounds(20, 460, 175, 30);



        /** AJOUTE LE CHOIX PAR BOUTON (NON FONCTIONNEL) */

        Button but = new Button();

        //JLabel l10 = new JLabel("role utilisateur :");
        //l10.setBounds(20, 515, 150, 30);


        /** AJOUT DU BOUTON "b" */


        JButton b = new JButton("Create");
        b.setBounds(500, 600, 80, 50);


        /** AJOUTS DES CASES CREES PRECEDEMENT */

        acc.add(nom);
        acc.add(password);
        acc.add(l1);
        acc.add(label);
        acc.add(l2);
        acc.add(l3);
        acc.add(l4);
        acc.add(l5);
        acc.add(l6);
        acc.add(l7);
        acc.add(l8);
        acc.add(l9);
        acc.add(prenom);
        acc.add(mail);
        acc.add(numero);
        acc.add(adresse);
        acc.add(postal);
        acc.add(siege);
        acc.add(distance);
        acc.add(but);

        //acc.add(l10);

        acc.add(b); // AJOUT DU BOUTON "b" SUR LA FENETRE "acc"


        acc.setSize(600, 700); // permet de définir les dimensions
        acc.setLocationRelativeTo(null); // Affiche la fenetre au centre de l'écran
        acc.setLayout(null);
        acc.setVisible(true); // Faire apparaître la fenêtre acc

        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                /** RAJOUTE TOUTES LES INFOS UTILISATEUR DANS UNE DATA */

                System.out.println("Voici vos informations: ");
                String data = "nom: " + nom.getText();
                data += ", Prénom: " + prenom.getText();
                data += ", Mail: " + mail.getText();
                data += ", Password: " + (password.getText());
                data += ", numéro portable: " + numero.getText();
                data += ", adresse postale: " + adresse.getText();
                data += ", code postal: " + postal.getText();
                data += ", siège le plus proche: " + siege.getText();
                data += ", distance estime: " + distance.getText();

                JTextArea  textArea1 = new JTextArea (data); // ECRIT LA DATA DANS UNE TextArea
                JScrollPane scrollPane = new JScrollPane(textArea1); // Met le TextArea dans un ScrollPanel plus simple pour l'affichage
                //pannel.setBounds(20, 600, 400, 100);
                scrollPane.setPreferredSize(new Dimension(560, 222)); // défini les dimensions du ScrollPanel
                pannel.add(scrollPane); // Add ScrollPanel to the Pannel
                acc.getContentPane().add(pannel); // Add the Pannel to the window
                acc.setVisible(true); // Set it visible
                //label.setText(data);


                Request request = new Request();
                request.signupRequest(nom.getText(), prenom.getText(), mail.getText(),password.getText(),numero.getText(),adresse.getText(),postal.getText(),siege.getText(),distance.getText());


                PopupCreation pc = new PopupCreation();

                acc.dispose();

                }
        });
    }
}

