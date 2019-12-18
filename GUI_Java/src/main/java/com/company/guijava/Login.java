package com.company.guijava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    JTextField text = new JTextField();

    JTextField value = new JTextField();

    public String getValue() {
        return value.getText();
    }

    public String getText() {
        return text.getText();
    }

    public Login() {

        JFrame signup = new JFrame("Sign Up");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        this.value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        JLabel l1 = new JLabel("Username:");
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
        signup.setSize(300, 250);
        signup.setLayout(null);
        signup.setVisible(true);

        com.company.guijava.Connexion co = new com.company.guijava.Connexion();
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                co.connect(getText(),getValue());
            }
        });

        JPanel pannel = new JPanel();
        JLabel jLabel1 =new JLabel("Mon texte dans JLabel");
        pannel.add(jLabel1);

        ImageIcon icone = new ImageIcon("ez.png");
        JLabel jLabel2 =new JLabel(icone);
        pannel.add(jLabel2);

        JLabel jLabel3 =new JLabel("Mon texte",icone,SwingConstants.LEFT);
        pannel.add(jLabel3);

        signup.getContentPane().add(pannel);
        signup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        signup.setLocationRelativeTo(null); // Affiche la fenetre au centre de l'écran
        signup.setVisible(true);
    }
}





