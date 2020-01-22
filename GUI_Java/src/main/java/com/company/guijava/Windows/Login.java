package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    boolean isInDatabase;
    JTextField text = new JTextField();

    JTextField value = new JTextField();

    public String getValue() {
        return value.getText();
    }

    public String getText() {
        return text.getText();
    }

    public Login() {

        JFrame signup = new JFrame("Connexion");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        this.value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        JLabel l1 = new JLabel("Mail:");
        l1.setBounds(20, 20, 80, 30);
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 75, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(100, 120, 80, 30);
        this.text = new JTextField();
        text.setBounds(100, 20, 100, 30);


        signup.add(value);
        signup.add(l1);
        signup.add(label);
        signup.add(l2);
        signup.add(b);
        signup.add(text);
        signup.setSize(250, 210);
        signup.setResizable(false);
        signup.setLayout(null);
        signup.setVisible(true);
        /*
        com.company.guijava.Connexion co = new com.company.guijava.Connexion();
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                co.connect(getText(),getValue());
            }
        });*/
        JPanel pannel = new JPanel();
        JLabel jLabel1 =new JLabel("Mon texte dans JLabel");
        pannel.add(jLabel1);

        ImageIcon icon = new ImageIcon("GUI_Java/imgs/database-icon.png");
        JLabel logo = new JLabel("", icon, JLabel.CENTER);
        signup.add(logo);

        signup.getContentPane().add(pannel);
        signup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        signup.setLocationRelativeTo(null); // Affiche la fenetre au centre de l'écran
        signup.setVisible(true);


        Request request = new Request();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserWindow uw = new UserWindow();
                    signup.dispose();

                /*boolean isIndatabase =request.loginRequest(getText(), getValue());
                if (isIndatabase){
                    System.out.println("in database");    // A REMETTRE QUAND LA BDD EST ON
                    UserWindow uw = new UserWindow();*/
                }
            });
        }

    }





