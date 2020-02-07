package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La classe permet d'ajouter un nouveau produit à un projet existant
 */

public class AddProductToProject extends JFrame {
    private boolean isFull=false;

    private String idProduct;
    private String largeur="";
    private String longueur="";
    private String epaisseur="";
    private String color;
    private List<String> materialInfo;
    private String prix_ht;

    /**
     * Permet d'ajouter un produit à un projet
     * @param idProject : Recupere l'id du Projet
     */

    public AddProductToProject(String idProject) {


        JFrame aptp = this;

        this.setTitle("Adding Project");

        final JTextField largeurField = new JTextField();
        largeurField.setBounds(370, 350, 100, 30);

        final JTextField longueurField = new JTextField();
        longueurField.setBounds(600, 350, 100, 30);

        final JTextField epaisseurField = new JTextField();
        epaisseurField.setBounds(850, 350, 100, 30);

        JLabel l1 = new JLabel("Produit :");
        l1.setBounds(30, 350, 80, 30);
        JLabel l2 = new JLabel("Largeur (cm):");
        l2.setBounds(284, 350, 90, 30);
        JLabel l3 = new JLabel("Longueur (cm):");
        l3.setBounds(500, 350, 100, 30);
        JLabel l4 = new JLabel("Epaisseur (mm):");
        l4.setBounds(740, 350, 100, 30);

        JLabel l10 = new JLabel("Armature :");
        l10.setBounds(340, 450, 120, 30);
        JLabel l11 = new JLabel("Panneau supérieur :");
        l11.setBounds(340, 480, 140, 30);
        JLabel l12 = new JLabel("Panneau inférieur :");
        l12.setBounds(340, 510, 120, 30);

        JLabel l8 = new JLabel("Tva 10 % | Prix Total :");
        l8.setBounds(350, 650, 330, 30);

        JButton b = new JButton("Add");
        b.setBounds(870, 700, 80, 50);

        JButton c = new JButton("Confirm");
        c.setBounds(20, 700, 80, 50);

        List<String> valuesType = new Request().listOfProduct();
        String[] listType = new String[valuesType.size()];
        for (int i=0; i<valuesType.size(); i++){
            listType[i]=valuesType.get(i);
        }

        JComboBox comboBoxType=new JComboBox(listType);
        comboBoxType.setBounds(90, 316, 150, 100);

        List<String> valuesMaterial = new Request().listOfMaterial();
        String[] listMaterial = new String[valuesMaterial.size()];
        for (int i=0; i<valuesMaterial.size(); i++){
            listMaterial[i]=valuesMaterial.get(i);
        }

        JComboBox comboBoxMaterial=new JComboBox(listMaterial);
        comboBoxMaterial.setBounds(486, 440, 170, 50);

        JComboBox comboBoxMaterial2=new JComboBox(listMaterial);
        comboBoxMaterial2.setBounds(486, 470, 170, 50);

        JComboBox comboBoxMaterial3=new JComboBox(listMaterial);
        comboBoxMaterial3.setBounds(486, 500, 170, 50);


        this.add(comboBoxType);
        this.add(comboBoxMaterial);
        this.add(comboBoxMaterial2);
        this.add(comboBoxMaterial3);

        this.add(epaisseurField);
        this.add(longueurField);
        this.add(largeurField);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l8);
        this.add(l10);
        this.add(l11);
        this.add(l12);

        this.add(b);
        this.add(c);


        c.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {

                if (!largeurField.getText().isEmpty() && !longueurField.getText().isEmpty() && !epaisseurField.getText().isEmpty()){
                    Request request = new Request();
                    String name_produit = comboBoxType.getSelectedItem().toString();

                idProduct = request.selectIdProduct(name_produit);

                float largInt = Float.parseFloat(largeurField.getText())/100;
                largeur = String.valueOf(Math.round(largInt*100));
                float longInt = Float.parseFloat(longueurField.getText())/100;
                longueur = String.valueOf(Math.round(longInt*100));
                float dimension = largInt*longInt;

                epaisseur = epaisseurField.getText();
                String material = comboBoxMaterial.getSelectedItem().toString();
                materialInfo = request.selectIdMaterial(material);
                float priceFloat = Math.round(Float.parseFloat(materialInfo.get(1))*dimension);

                prix_ht = String.valueOf(priceFloat);
                isFull=true;
                l8.setText("Tva 10 % | Prix Total: " + prix_ht +"€");
            }
                else {
                isFull=false;
                JOptionPane.showMessageDialog(null, "Please complete all field !", "Alert !", JOptionPane.INFORMATION_MESSAGE);
            }

            }
        });

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isFull){
                    Request request = new Request();
                    request.InsertProductToProject(idProject, idProduct , largeur, longueur, epaisseur, prix_ht);
                    aptp.dispose();
                    new AboutProject(idProject);
                }
            }
        });

        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

    }
}


