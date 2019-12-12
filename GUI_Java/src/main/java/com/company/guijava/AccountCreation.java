package com.company.guijava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AccountCreation extends JFrame {

    public AccountCreation() {

        JFrame acc = new JFrame("Account Creation");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JPasswordField value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        JPanel pannel = new JPanel();
        pannel.setBounds(5, 530, 600, 40);
        final JLabel lab1 = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JLabel lab2 = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JLabel lab3 = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JLabel lab4 = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JLabel lab5 = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JLabel lab6 = new JLabel();
        label.setBounds(20, 150, 200, 50);


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
        JLabel l8 = new JLabel("siège le plus proche :");
        l8.setBounds(20, 405, 150, 30);
        JLabel l9 = new JLabel("distance estime :");
        l9.setBounds(20, 460, 150, 30);



        ButtonGroup group = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton("User");
        radio1.setMnemonic(KeyEvent.VK_1);
        radio1.setActionCommand("User");
        radio1.setSelected(true);

        JRadioButton radio2 = new JRadioButton("Admin");
        radio2.setMnemonic(KeyEvent.VK_2);
        radio2.setActionCommand("Admin");


        //JLabel l10 = new JLabel("role utilisateur :");
        //l10.setBounds(20, 515, 150, 30);


        JButton b = new JButton("Create");
        b.setBounds(500, 600, 80, 50);
        final JTextField text = new JTextField();
        text.setBounds(100, 20, 100, 30);
        acc.add(value);
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
        //acc.add(l10);
        acc.add(radio1);
        acc.add(radio2);

        acc.add(b);
        acc.add(text);
        acc.setSize(600, 700);
        acc.setLocationRelativeTo(null); // Affiche la fenetre au centre de l'écran
        acc.setLayout(null);
        acc.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Voici vos informations: ");
                String data = "nom: " + text.getText();
                data += ", Prénom: " + text.getText();
                data += ", Mail: " + text.getText();
                data += ", Password: "
                        + new String(value.getPassword());
                data += ", numéro portable: " + text.getText();
                data += ", adresse postale: " + text.getText();
                data += ", code postal: " + text.getText();
                data += ", siège le plus proche: " + text.getText();
                data += ", distance estime: " + text.getText();

                JTextArea  textArea1 = new JTextArea (data);
                JScrollPane scrollPane = new JScrollPane(textArea1);
                //pannel.setBounds(20, 600, 400, 100);
                scrollPane.setPreferredSize(new Dimension(560, 222));
                pannel.add(scrollPane);
                acc.getContentPane().add(pannel);
                acc.setVisible(true);
                //label.setText(data);

            }
        });
    }
}

