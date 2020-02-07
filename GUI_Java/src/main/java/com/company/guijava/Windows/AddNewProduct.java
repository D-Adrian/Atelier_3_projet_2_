package com.company.guijava.Windows;

import com.company.guijava.RequestSQL.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe permet d'ajouter un nouveau produit
 */

public class AddNewProduct extends JFrame {

    public AddNewProduct() {

        JFrame f = this;

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        final JLabel label = new JLabel();
        label.setBounds(210, 10, 300, 40);
        label.setFont(new Font("Courier New", Font.BOLD, 18));
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setVisible(true);

        JButton validate = new JButton("Validate");
        validate.setBounds(350, 200, 100, 50);
        this.add(validate);

        final JTextField nomProduct = new JTextField();
        nomProduct.setBounds(200, 120, 200, 30);

        JLabel np = new JLabel("Nom du Produit :");
        np.setBounds(40, 120, 140, 30);

        this.add(np);
        this.add(nomProduct);

        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Request request = new Request();
                request.newProduct(nomProduct.getText());
                f.dispose();
                new PopupProduct(" Produit successfully created ! ");

            }
        });
    }
}
