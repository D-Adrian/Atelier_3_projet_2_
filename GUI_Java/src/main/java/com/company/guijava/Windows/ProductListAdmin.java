package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Table.TableProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProductListAdmin extends JFrame {
    String[] header = {"nom du produit", "date d'ajout"};
    ModeleStatic model = new ModeleStatic(header);
    TableProduct door;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    /**
     * la méthode permet de lister tout les produits que propose l'entreprise que en mode admin
     */

    public ProductListAdmin() {

        JFrame uw = this;
        this.setTitle("Product List");

        JPanel buttonPan = new JPanel();


        JButton add_product = new JButton("Add Product");
        JButton delete_product = new JButton("Delete Product");


        this.setSize(600, 600);
        this.setLocationRelativeTo(null);

        buttonPan.add(add_product);
        buttonPan.add(delete_product);


        List<String> values;
        try {
            values = this.requestsSQL.DisplayProduct();
            if (!values.isEmpty()) {
                int i = 0;

                for (String infoArrive : values) {
                    this.arrivalInfo.add(infoArrive);
                    i++;
                    if (i == this.header.length) {
                        this.model.addInformation(new TableProduct(this.arrivalInfo.get(0), this.arrivalInfo.get(1)));
                        this.arrivalInfo.clear();
                        i = 0;
                    }
                }

            } else {
                this.door = new TableProduct(" ", " ");
            }
        } catch (Exception i) {
            System.out.println(i);
        }

        add_product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewProduct();
            }
        });


        this.panelTab.setLayout(new BorderLayout());
        JTable tableau = new JTable(this.model);
        this.panelTab.add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.CENTER);
        this.add(buttonPan, BorderLayout.SOUTH);

        delete_product.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     for (int i = 0; i < tableau.getColumnCount(); i++) {
                         if (tableau.getColumnName(i).equals("nom du produit")) {
                             Object obj = tableau.getValueAt(tableau.getSelectedRow(), i);
                             String nameProduct = (String) (obj);

                             Request request = new Request();
                             request.deleteProduct(nameProduct);
                             dispose();
                             new ProductListAdmin();
                         }
                     }
                 }
             }
        );

        this.setVisible(true);

    }
}