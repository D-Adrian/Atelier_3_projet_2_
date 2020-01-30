package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Table.TableDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AboutProject extends JFrame {
    String[] header = {"id_projet", "id_produit", "largeur_totale", "longueur_totale", "epaisseur_totale", "prix_ht", "tva"};
    ModeleStatic model = new ModeleStatic(header);
    TableDetails door;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    public AboutProject(String idProject) {

        JFrame uw = this;
        this.setTitle("Details");

        JPanel buttonPan = new JPanel();


        JButton b = new JButton("Add Product");
        JButton c = new JButton("Edit Product");
        JButton d = new JButton("Delete Product");


        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        buttonPan.add(b);
        buttonPan.add(c);
        buttonPan.add(d);



        List<String> values;
        try {
            values = this.requestsSQL.DisplayDetails(idProject);
            if (!values.isEmpty()) {
                int i = 0;

                for (String infoArrive : values) {
                    this.arrivalInfo.add(infoArrive);
                    i++;
                    if (i == this.header.length) {
                        this.model.addInformation(new TableDetails(this.arrivalInfo.get(0), this.arrivalInfo.get(1),this.arrivalInfo.get(2),this.arrivalInfo.get(3),this.arrivalInfo.get(4),this.arrivalInfo.get(5),this.arrivalInfo.get(6)));
                        this.arrivalInfo.clear();
                        i = 0;
                    }
                }

            }
            else { this.door = new TableDetails(" ", " ", " ", " ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        this.panelTab.setLayout(new BorderLayout());
        JTable tableau = new JTable(this.model);
        this.panelTab.add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.CENTER);
        this.add(buttonPan, BorderLayout.SOUTH);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        //dispose();
                new AddProductToProject(idProject);

                //uw.dispose();

            }
        });

        this.setVisible(true);
    }
}