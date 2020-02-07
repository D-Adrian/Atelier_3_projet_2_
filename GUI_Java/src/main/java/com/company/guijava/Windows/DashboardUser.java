package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Table.TableProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * La classe permet de crée un dashboard affichant tout les projets de l'utilisateur connecté
 */

public class DashboardUser extends JFrame {

    String[] header = {"id project", "nom du projet", "date de création", "description du projet", "date de fin"};
    ModeleStatic model = new ModeleStatic(header);
    TableProject boat;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    public DashboardUser() {

        JFrame uw = this;
        this.setTitle("Project List");

        JPanel buttonPan = new JPanel();


        JButton new_project = new JButton("New Project");
        JButton edit_my_project = new JButton("Edit my Project");
        JButton product_list = new JButton("Product List");


        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        buttonPan.add(new_project);
        buttonPan.add(edit_my_project);
        buttonPan.add(product_list);


        List<String> values;
        try {
            values = this.requestsSQL.DisplayProject();
            if (!values.isEmpty()) {
                int i = 0;

                for (String infoArrive : values) {
                    this.arrivalInfo.add(infoArrive);
                    i++;
                    if (i == this.header.length) {
                        this.model.addInformation(new TableProject(this.arrivalInfo.get(0), this.arrivalInfo.get(1), this.arrivalInfo.get(2),
                                this.arrivalInfo.get(3), this.arrivalInfo.get(4)));
                        this.arrivalInfo.clear();
                        i = 0;
                    }
                }

            }
            else { this.boat = new TableProject(" ", " ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        this.panelTab.setLayout(new BorderLayout());
        JTable tableau = new JTable(this.model);
        this.panelTab.add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.CENTER);
        this.add(buttonPan, BorderLayout.SOUTH);




        new_project.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddNewProject();


            }
        });

        product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<tableau.getColumnCount(); i++) {
                    if(tableau.getColumnName(i).equals("id project")) {
                        Object obj = tableau.getValueAt(tableau.getSelectedRow(), i);
                        String idProject = (String) (obj);


                        new AboutProject(idProject);
                        uw.dispose();

                    }
                }

            }
        });

        edit_my_project.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<tableau.getColumnCount(); i++) {
                    if(tableau.getColumnName(i).equals("id project")) {
                        Object obj = tableau.getValueAt(tableau.getSelectedRow(), i);
                        String idProject = (String) (obj);

                        new EditProject(idProject);
                        uw.dispose();

                    }
                }

            }
        });

        this.setVisible(true);
    }
}





