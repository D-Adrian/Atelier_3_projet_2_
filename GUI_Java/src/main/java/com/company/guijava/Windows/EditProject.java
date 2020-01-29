package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EditProject extends JFrame {

    public EditProject(String idProject)
    {

        Request request=new Request();
        List<String> values =request.DisplayProjectToEdit(idProject);
        JFrame f = this;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New", Font.BOLD, 18));
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setVisible(true);

        JButton validate = new JButton("Update");
        validate.setBounds(350, 300, 100, 50);
        this.add(validate);

        final JTextField nomProjet = new JTextField();
        nomProjet.setText(values.get(0));
        nomProjet.setBounds(135, 20, 350, 30);

        final JTextField description = new JTextField();
        description.setText(values.get(1));
        description.setBounds(135, 75, 350, 150);



        JLabel np = new JLabel("Nom du Projet:");
        np.setBounds(20, 20, 100, 30);
        JLabel desc = new JLabel("Description:");
        desc.setBounds(20, 75, 100, 30);

        this.add(np);
        this.add(desc);
        this.add(nomProjet);
        this.add(description);


        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Request request = new Request();
                request.editProject(idProject, nomProjet.getText(), description.getText());
                new PopupProject(" Project updated! ");
                f.dispose();
                new DashboardUser();
            }
        });
    }
}
