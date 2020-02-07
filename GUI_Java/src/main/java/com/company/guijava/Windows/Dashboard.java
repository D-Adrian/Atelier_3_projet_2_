package com.company.guijava.Windows;

import com.company.guijava.ModeleStatic;
import com.company.guijava.RequestSQL.Request;
import com.company.guijava.Save.JSonReader;
import com.company.guijava.Table.TableProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *La classe permet d'afficher un dashboard Admin différent de celui de l'utilisateur
 */

public class Dashboard extends JFrame {
    String[] header = {"id project", "nom du projet", "date de création", "description du projet", "date de fin"};
    ModeleStatic model = new ModeleStatic(header);
    TableProject door;
    ArrayList<String> arrivalInfo = new ArrayList<String>();

    Request requestsSQL = new Request();
    JPanel panelTab = new JPanel();

    public Dashboard() {

        JFrame uw = this;
        this.setTitle("Dashboard");

        JPanel buttonPan = new JPanel();

        JButton new_project = new JButton("New Project");
        JButton edit_project = new JButton("Edit Project");
        JButton end_a_project = new JButton("End Project");
        JButton delete_project = new JButton("Delete Project");
        JButton product_list = new JButton("Product List");

        new_project.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewProject();
                dispose();
            }
        });

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);

        buttonPan.add(new_project);
        buttonPan.add(edit_project);
        buttonPan.add(end_a_project);
        buttonPan.add(delete_project);
        buttonPan.add(product_list);


        List<String> values;
        try {
            List<String> userSession = new JSonReader().readFileLoginSession("src/main/java/com/company/guijava/userSession.json");
            if(userSession.get(3).toLowerCase().equals("admin")){
                values = this.requestsSQL.DisplayProjectAdmin();
            }
            else if(userSession.get(3).toLowerCase().equals("utilisateur")){
                values = this.requestsSQL.DisplayProject();
            }
            else{
                values=new ArrayList<>();
            }
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
            else { this.door = new TableProject(" ", " ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        this.panelTab.setLayout(new BorderLayout());
        JTable tableau = new JTable(this.model);
        this.panelTab.add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.CENTER);
        this.add(buttonPan, BorderLayout.SOUTH);
        buttonPan.setLayout(new GridLayout(1,4));


        product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ProductListAdmin();

            }
        });

        edit_project.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i=0; i<tableau.getColumnCount(); i++) {
                    if(tableau.getColumnName(i).equals("id project")) {
                        Object obj = tableau.getValueAt(tableau.getSelectedRow(), i);
                        String idProject = (String) (obj);

                        new EditProjectAdmin(idProject);
                        uw.dispose();
                    }
                }

            }
        });

        end_a_project.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<tableau.getColumnCount(); i++) {
                    if(tableau.getColumnName(i).equals("id project")) {
                        Object obj = tableau.getValueAt(tableau.getSelectedRow(), i);
                        String idProject = (String) (obj);

                        Request request = new Request();
                        request.endProject(idProject);
                        dispose();
                        new Dashboard();
                    }
                }
            }
        });

        delete_project.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<tableau.getColumnCount(); i++) {
                    if(tableau.getColumnName(i).equals("id project")) {
                        Object obj = tableau.getValueAt(tableau.getSelectedRow(), i);
                        String idProject = (String) (obj);

                        Request request = new Request();
                        request.deleteProject(idProject);
                        dispose();
                        new Dashboard();
                    }
                }
            }
        });

        this.setVisible(true);
    }
}






