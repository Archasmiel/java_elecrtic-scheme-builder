package com.company;

import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel panel;

    public MyFrame() {
        panel = new MyPanel();

        this.add(panel);
        this.pack();

        this.setTitle("Scheme Builder");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }








}
