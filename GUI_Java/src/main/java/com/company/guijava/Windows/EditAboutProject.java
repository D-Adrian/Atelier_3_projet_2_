package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.util.List;

public class EditAboutProject extends JFrame {

    public EditAboutProject() {

        final JTextField largeur = new JTextField();
        largeur.setBounds(360, 350, 100, 30);

        final JTextField longueur = new JTextField();
        longueur.setBounds(600, 350, 100, 30);

        final JTextField epaisseur = new JTextField();
        epaisseur.setBounds(850, 350, 100, 30);


        JLabel l1 = new JLabel("Produit :");
        l1.setBounds(30, 350, 80, 30);
        JLabel l2 = new JLabel("Largeur :");
        l2.setBounds(290, 350, 80, 30);
        JLabel l3 = new JLabel("Longueur :");
        l3.setBounds(520, 350, 80, 30);
        JLabel l4 = new JLabel("Epaisseur :");
        l4.setBounds(760, 350, 80, 30);
        JLabel l5 = new JLabel("Couleur :");
        l5.setBounds(290, 450, 80, 30);
        JLabel l6 = new JLabel("Matériau :");
        l6.setBounds(520, 450, 80, 30);


        JLabel l7 = new JLabel("Tva 10 % | Prix Total :");
        l7.setBounds(350, 650, 160, 30);

        JButton b = new JButton("Add");
        b.setBounds(870, 700, 80, 50);


        List<String> valuesType = new Request().listOfProduct();
        String[] listType = new String[valuesType.size()];
        for (int i=0; i<valuesType.size(); i++){
            listType[i]=valuesType.get(i);
        }
        JComboBox comboBoxType=new JComboBox(listType);
        comboBoxType.setBounds(90, 316, 150, 100);


        String[] listColor = {"vert", "rouge", "bleu", "jaune", "orange", "violet", "rose"};
        JComboBox comboBoxColor=new JComboBox(listColor);
        comboBoxColor.setBounds(350, 416, 100, 100);

        List<String> valuesMaterial = new Request().listOfMaterial();
        String[] listMaterial = new String[valuesMaterial.size()];
        for (int i=0; i<valuesMaterial.size(); i++){
            listMaterial[i]=valuesMaterial.get(i);
        }
        JComboBox comboBoxMaterial=new JComboBox(listMaterial);
        comboBoxMaterial.setBounds(586, 416, 100, 100);

        this.add(comboBoxType);
        this.add(comboBoxColor);
        this.add(comboBoxMaterial);


        this.add(epaisseur);
        this.add(longueur);
        this.add(largeur);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        this.add(l7);



        this.add(b);

        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

    }
}


