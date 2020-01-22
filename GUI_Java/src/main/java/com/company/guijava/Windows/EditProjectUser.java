package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.TableProduct;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditProjectUser extends JFrame {
    String[] header = {"Mois", "Gain"};
    ModeleStatic model = new ModeleStatic(header);
    TableProduct door;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    public EditProjectUser() {

        JFrame uw = new JFrame("Product List");
        this.setTitle("Product List");


        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);

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
            else { this.door = new TableProduct(" ", "");}
        } catch (Exception i) {
            System.out.println(i);
        }

        this.panelTab.setLayout(new BorderLayout());
        JTable tableau = new JTable(this.model);
        this.panelTab.add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.CENTER);

        this.setVisible(true);
    }
}