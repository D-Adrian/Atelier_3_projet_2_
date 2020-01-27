package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Save.JSonReader;
import com.company.guijava.Save.JsonWriterLogin;
import com.company.guijava.Save.StateListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Login extends JFrame {

    boolean isInDatabase;
    JTextField text = new JTextField();
    JTextField value = new JPasswordField();

    public String getValue() {
        return value.getText();
    }

    public String getText() {
        return text.getText();
    }

    public Login() {

        JFrame login = this;

        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("imgs/Leroy_Merlu.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JPanel panImg= new JPanel(new GridLayout(2, 1));
        JLabel labelimage = new JLabel(imageIcon);
        panImg.add(labelimage);
        panImg.setOpaque(false);

        JLabel label = new JLabel();
        label.setBounds(20, 150, 100, 50);
        this.value = new JPasswordField();
        value.setBounds(160, 285, 180, 30);
        JCheckBox cb = new JCheckBox();
        cb.setBounds(13, 440, 20, 30);
        cb.setLayout(new BorderLayout());
        Border margin = new EmptyBorder(10, 2, 4, 10);
        cb.setBorder(margin);
        cb.addActionListener(new StateListener());
        try{
            JSonReader register = new JSonReader();
            List<String> loginRegister = register.readFileLoginRegister("src/main/java/com/company/guijava/userRegister.json");
            value.setText(loginRegister.get(0));
            text.setText(loginRegister.get(1));
            cb.setSelected(true);

        }catch (Exception e){

        }
        text.setBounds(160, 240, 180, 30);
        JLabel l1 = new JLabel("Mail:");
        l1.setBounds(30, 243, 80, 30);
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(30, 288, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(210, 340, 80, 30);
        JButton f = new JButton("Register");
        f.setBounds(200, 370, 100, 30);


        JLabel jb = new JLabel("Keep me logged in");
        jb.setBounds(36, 443, 120, 28);


        this.setSize(500, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.add(value);
        this.add(l1);
        this.add(label);
        this.add(l2);
        this.add(b);
        this.add(f);
        this.add(text);
        this.add(cb);
        this.add(jb);
        this.add(panImg);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer le processus avec la croix rouge

        /*
        com.company.guijava.Connexion co = new com.company.guijava.Connexion();
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                co.connect(getText(),getValue());
            }
        });*/

        this.setLocationRelativeTo(null); // Affiche la fenetre au centre de l'écran
        this.setVisible(true);


        f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // PERMET D'OUVRIR LA FENETRE D'INSCRIPTION

                AccountCreation acc = new AccountCreation();
            }
        });

        Request request = new Request();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mail = text.getText();
                String password = value.getText();

                List<String> values =request.loginRequest(getText(), getValue());
                if (!values.isEmpty()){
                    if (cb.isSelected()) {
                        System.out.println(mail + password);
                        try {
                            new JsonWriterLogin().writeInFileRegister(mail, password, "src/main/java/com/company/guijava/userRegister.json");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    try {
                        new JsonWriterLogin().writeInFileSession(mail, password, values.get(2), values.get(3), "src/main/java/com/company/guijava/userSession.json");
                        List<String> userSession = new JSonReader().readFileLoginSession("src/main/java/com/company/guijava/userSession.json");
                        if (userSession.get(3).toLowerCase().equals("utilisateur")){
                            new Gui();
                            login.dispose();
                        }
                        else if(userSession.get(3).toLowerCase().equals("admin")){
                            new AdminMenu();
                            login.dispose();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("in database");    // A REMETTRE QUAND LA BDD EST ON
                }
                else {
                        new PopupErrorConnexion();
                }
            }
        });
    }

}





