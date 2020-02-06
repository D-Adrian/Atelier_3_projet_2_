package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Table.TableDetails;
import com.company.guijava.Table.TableDevis;
import com.company.guijava.Table.TableGain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DevisWindow extends JFrame {

    String[] header = {"Designation", "Price"};
    ModeleStatic model = new ModeleStatic(header);
    TableDevis devis;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();


    public DevisWindow() {

        JFrame frame = new JFrame("Devis Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New",Font.BOLD, 18));
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        List<String> values;
        try {
            values = this.requestsSQL.DisplayDevis();
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
            else { this.devis = new TableDevis(" ", " ");}
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
