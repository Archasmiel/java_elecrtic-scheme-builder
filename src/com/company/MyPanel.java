package com.company;

import com.company.lib.DrawLib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel extends JPanel {

    DrawLib draw;

    public MyPanel() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + "," + e.getY());
            }

        });
        this.setPreferredSize(new Dimension(1000, 500));
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }



    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        draw = new DrawLib(g2D, false, false, false);

        //draw.mesh(50, 50, 5);

        draw5();
    }

    private void draw1() {
        draw.contact(150, 50, "Б");
        draw.contact(275, 300, "П");
        draw.contact(115, 225, "Э");
        draw.npn(100, 100,   100,     0.0,   true, "VT0");
        draw.pnp(300,  45,   100,   180.0,   false, "VT1");
        draw.cap(50, 100,   50,   90.0);
        draw.cap(250, 200,   50,   90.0);
        draw.res(200, 145,   50,   0.0);


        draw.connectDots(150, 100,   150, 50,   true);
        draw.connectDots(150, 75,   75, 100,   true);
        draw.connectDots(75, 150,   100, 170,   false);
        draw.connectDots(275, 75,   250, 170,   false);
        draw.connectDots(150, 75,   275, 75,   false);
        draw.connectDots(275, 200,   275, 170,   false);
        draw.connectDots(275, 300,   275, 250,   false);
        draw.connectDots(300, 75,   275, 75,   false);
        draw.connectDots(425, 275,   400, 75,   false);
        draw.connectDots(275, 275,   425, 275,   false);
        draw.connectDots(350, 145,   275, 170,   false);
        draw.connectDots(115, 170,   115, 225,   false);

        draw.dot(150, 75);
        draw.dot(275, 75);
        draw.dot(275, 170);
        draw.dot(275, 275);
    }
    private void draw2() {
        draw.contact(150, 50, "Б");
        draw.contact(275, 300, "П");
        draw.contact(115, 225, "Э");
        draw.npn(100, 100,   100,     0.0,   true, "VT0");
        draw.pnp(300,  45,   100,   180.0,   false, "VT1");
        draw.cap(50, 100,   50,   90.0);
        draw.cap(250, 200,   50,   90.0);
        draw.res(200, 145,   50,   0.0);


        draw.connectDots(150, 100,   150, 50,   true);
        draw.connectDots(150, 75,   75, 100,   true);
        draw.connectDots(75, 150,   100, 170,   false);
        draw.connectDots(275, 170,   250, 170,   false);
        draw.connectDots(150, 75,   275, 75,   false);
        draw.connectDots(275, 200,   275, 170,   false);
        draw.connectDots(275, 300,   275, 250,   false);
        draw.connectDots(300, 75,   275, 75,   false);
        draw.connectDots(425, 275,   400, 75,   false);
        draw.connectDots(275, 275,   425, 275,   false);
        draw.connectDots(350, 145,   275, 170,   false);
        draw.connectDots(115, 170,   115, 225,   false);

        draw.dot(150, 75);
        draw.dot(275, 170);
        draw.dot(275, 275);
    }
    private void draw3() {
        draw.contact(150, 50, "Б");
        draw.contact(275, 300, "П");
        draw.contact(185, 225, "K");
        draw.npn(100, 100,   100,     0.0,   true, "VT0");
        draw.pnp(300,  45,   100,   180.0,   false, "VT1");
        draw.cap(175, 100,   50,   90.0);
        draw.cap(250, 200,   50,   90.0);
        draw.res(200, 145,   50,   0.0);


        draw.connectDots(150, 100,   150, 50,   true);
        draw.connectDots(150, 75,   75, 150,   true);
        draw.connectDots(75, 150,   100, 170,   false);
        draw.connectDots(275, 170,   250, 170,   false);
        draw.connectDots(150, 75,   275, 75,   false);
        draw.connectDots(275, 200,   275, 170,   false);
        draw.connectDots(275, 300,   275, 250,   false);
        draw.connectDots(300, 75,   275, 75,   false);
        draw.connectDots(425, 275,   400, 75,   false);
        draw.connectDots(275, 275,   425, 275,   false);
        draw.connectDots(350, 145,   275, 170,   false);
        draw.connectDots(185, 170,   185, 225,   false);
        draw.connectDots(200, 100,   200, 75,   false);
        draw.connectDots(200, 150,   200, 170,   false);

        draw.dot(150, 75);
        draw.dot(275, 170);
        draw.dot(275, 275);
        draw.dot(200, 75);
        draw.dot(200, 170);
    }
    private void draw4() {
        draw.contact(150, 50, "Б");
        draw.contact(275, 300, "П");
        draw.contact(185, 225, "K");
        draw.npn(100, 100,   100,     0.0,   true, "VT0");
        draw.pnp(300,  45,   100,   180.0,   false, "VT1");
        draw.cap(175, 100,   50,   90.0);
        draw.cap(250, 200,   50,   90.0);
        draw.res(200, 145,   50,   0.0);


        draw.connectDots(150, 100,   150, 50,   true);
        draw.connectDots(275, 170,   250, 170,   false);
        draw.connectDots(150, 75,   275, 75,   false);
        draw.connectDots(275, 200,   275, 170,   false);
        draw.connectDots(275, 300,   275, 250,   false);
        draw.connectDots(300, 75,   275, 75,   false);
        draw.connectDots(425, 275,   400, 75,   false);
        draw.connectDots(275, 275,   425, 275,   false);
        draw.connectDots(350, 145,   275, 170,   false);
        draw.connectDots(185, 170,   185, 225,   false);
        draw.connectDots(200, 100,   200, 75,   false);
        draw.connectDots(200, 150,   200, 170,   false);

        draw.dot(150, 75);
        draw.dot(275, 170);
        draw.dot(275, 275);
        draw.dot(200, 75);
        draw.dot(200, 170);
    }
    private void draw5() {
        draw.contact(150, 50, "Б");
        draw.contact(275, 300, "П");
        draw.contact(150, 225, "КЭ");
        draw.npn(100, 100,   100,     0.0,   true, "VT0");
        draw.pnp(300,  45,   100,   180.0,   false, "VT1");
        draw.cap(50, 100,   50,   90.0);
        draw.cap(250, 200,   50,   90.0);
        draw.res(200, 145,   50,   0.0);


        draw.connectDots(150, 100,   150, 50,   true);
        draw.connectDots(150, 75,   75, 100,   true);
        draw.connectDots(75, 150,   100, 170,   false);
        draw.connectDots(275, 170,   250, 170,   false);
        draw.connectDots(150, 75,   275, 75,   false);
        draw.connectDots(275, 200,   275, 170,   false);
        draw.connectDots(275, 300,   275, 250,   false);
        draw.connectDots(300, 75,   275, 75,   false);
        draw.connectDots(425, 275,   400, 75,   false);
        draw.connectDots(275, 275,   425, 275,   false);
        draw.connectDots(350, 145,   275, 170,   false);
        draw.connectDots(150, 170,   150, 225,   false);
        draw.connectDots(115, 170,   185, 170,   false);

        draw.dot(150, 75);
        draw.dot(150, 170);
        draw.dot(275, 170);
        draw.dot(275, 275);
        draw.dot(115, 170);
        draw.dot(185, 170);
    }

}
