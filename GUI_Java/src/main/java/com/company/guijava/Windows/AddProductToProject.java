package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddProductToProject extends JFrame {
    private boolean isFull=false;

    private String idProduct;
    private String largeur="";
    private String longueur="";
    private String epaisseur="";
    private String color;
    private List<String> materialInfo;
    private String prix_ht;


    public AddProductToProject(String idProject) {

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
        JLabel l5 = new JLabel("Module :");
        l5.setBounds(250, 450, 80, 30);
        JLabel l6 = new JLabel("Matériau :");
        l6.setBounds(520, 450, 80, 30);

        JLabel l7 = new JLabel("Tva 10 % | Prix Total :");
        l7.setBounds(350, 650, 330, 30);

        JButton b = new JButton("Confirm");
        b.setBounds(870, 700, 80, 50);

        JButton c = new JButton("Add");
        c.setBounds(20, 700, 80, 50);

        List<String> valuesType = new Request().listOfProduct();
        String[] listType = new String[valuesType.size()];
        for (int i=0; i<valuesType.size(); i++){
            listType[i]=valuesType.get(i);
        }
        JComboBox comboBoxType=new JComboBox(listType);
        comboBoxType.setBounds(90, 316, 150, 100);


        String[] listModule = {"armature", "panneau superieur", "panneau inferieur"};
        JComboBox comboBoxColor=new JComboBox(listModule);
        comboBoxColor.setBounds(310, 416, 180, 100);

        List<String> valuesMaterial = new Request().listOfMaterial();
        String[] listMaterial = new String[valuesMaterial.size()];
        for (int i=0; i<valuesMaterial.size(); i++){
            listMaterial[i]=valuesMaterial.get(i);
        }
        JComboBox comboBoxMaterial=new JComboBox(listMaterial);
        comboBoxMaterial.setBounds(586, 416, 170, 100);

        this.add(comboBoxType);
        this.add(comboBoxColor);
        this.add(comboBoxMaterial);

        this.add(epaisseurField);
        this.add(longueurField);
        this.add(largeurField);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        this.add(l7);

        this.add(b);
        this.add(c);


        b.addActionListener(new ActionListener() {
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
                color = comboBoxColor.getSelectedItem().toString();
                String material = comboBoxMaterial.getSelectedItem().toString();
                materialInfo = request.selectIdMaterial(material);
                float priceFloat = Math.round(Float.parseFloat(materialInfo.get(1))*dimension);

                prix_ht = String.valueOf(priceFloat);
                isFull=true;
                l7.setText("Tva 10 % | Prix Total: " + prix_ht +"€");
            }
                else {
                isFull=false;
                JOptionPane.showMessageDialog(null, "Please complete all field !", "Alert !", JOptionPane.INFORMATION_MESSAGE);
            }

            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isFull){
                    Request request = new Request();
                    request.InsertProductToProject(idProject, idProduct , largeur, longueur, epaisseur, prix_ht);
                }
            }
        });

        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

    }
}


