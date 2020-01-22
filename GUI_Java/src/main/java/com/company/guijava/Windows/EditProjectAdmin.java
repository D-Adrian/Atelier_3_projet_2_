package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.TableProduct;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditProjectAdmin extends JFrame {
    String[] header = {"nom du produit", "date d'ajout"};
    ModeleStatic model = new ModeleStatic(header);
    TableProduct door;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    public EditProjectAdmin() {

        JFrame uw = new JFrame("Product List");
        this.setTitle("Product List");

        JPanel buttonPan = new JPanel();


        JButton b = new JButton("Add Product");
        JButton d = new JButton("Delete Product");


        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        buttonPan.add(b);
        buttonPan.add(d);



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

            }
            else { this.door = new TableProduct(" ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        this.panelTab.setLayout(new BorderLayout());
        JTable tableau = new JTable(this.model);
        this.panelTab.add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.CENTER);
        this.add(buttonPan, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}