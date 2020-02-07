package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Table.TableDevis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe permet d'afficher une fenêtre affichant tout les devis des projets des utilisateurs
 */

public class DevisWindowAdmin extends JFrame {

    String[] header = {"Designation", "Price"};
    ModeleStatic model = new ModeleStatic(header);
    TableDevis devis;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    public DevisWindowAdmin() {

        JFrame frame = new JFrame("Devis Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        List<String> values;
        try {
            values = this.requestsSQL.DisplayDevisUser();
            if (!values.isEmpty()) {
                int i = 0;

                for (String infoArrive : values) {
                    this.arrivalInfo.add(infoArrive);
                    i++;
                    if (i == this.header.length) {
                        this.model.addInformation(new TableDevis(this.arrivalInfo.get(0), this.arrivalInfo.get(1)));
                        this.arrivalInfo.clear();
                        i = 0;
                    }
                }

            }
            else {
                this.devis = new TableDevis(" ", " ");}
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
