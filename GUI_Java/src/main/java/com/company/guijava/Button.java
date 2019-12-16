/**package com.company.guijava;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Button extends JFrame {
    public static void main(String args[]) {

        Button app = new Button();
        app.setTitle("Test radio boutons");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Border border = BorderFactory.createTitledBorder("Sélection");
        panel.setBorder(border);

        ButtonGroup group = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton("Choix 1");
        radio1.setMnemonic(KeyEvent.VK_1);
        radio1.setActionCommand("Choix_1");
        radio1.setSelected(true);

        JRadioButton radio2 = new JRadioButton("Choix 2");
        radio2.setMnemonic(KeyEvent.VK_2);
        radio2.setActionCommand("Choix_2");

        JRadioButton radio3 = new JRadioButton("Choix 3");
        radio3.setMnemonic(KeyEvent.VK_3);
        radio3.setActionCommand("Choix_3");

        group.add(radio1);
        panel.add(radio1);
        group.add(radio2);
        panel.add(radio2);
        group.add(radio3);
        panel.add(radio3);

        Container contentPane = app.getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        app.setSize(300, 150);
        app.setVisible(true);

    }
}
 */



