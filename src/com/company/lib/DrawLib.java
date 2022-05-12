package com.company.lib;

import com.company.objects.Line;
import com.company.objects.Point;

import java.awt.*;

public class DrawLib {

    public Graphics2D g2D;
    boolean drawBoxes, drawCircles, drawContacts;

    public DrawLib(Graphics2D g2D, boolean drawBoxes, boolean drawCircles, boolean drawContacts) {
        this.g2D = g2D;
        this.drawBoxes = drawBoxes;
        this.drawCircles = drawCircles;
        this.drawContacts = drawContacts;
    }



    // meshes
    public void mesh(int dx, int dy, int len){
        this.dotMesh(dx, dy);
        this.dottedLineMesh(dx, dy, len);
        g2D.setColor(new Color(128, 128, 128));
        g2D.drawString(dx + "x" + dy, dx/8, dy/4);
        g2D.setColor(new Color(0, 0, 0));
    }
    public void dotMesh(int dx, int dy) {
        g2D.setColor(new Color(190, 190, 190));
        for (int i = 0 ; i < 30 ; i++) {
            for (int j = 0 ; j < 30 ; j++) {
                this.dot(i*dx, j*dy);
            }
        }
        g2D.setColor(new Color(0, 0, 0));
    }
    public void dottedLineMesh(int dx, int dy, int len){
        g2D.setColor(new Color(190, 190, 190));
        for (int i = 0 ; i < 30 ; i++) {
            int y = 0;
            while (y < 30*dy){
                this.line(i*dx, y, i*dx, y+len);
                y += 2*len;
            }
        }
        for (int j = 0 ; j < 30 ; j++) {
            int x = 0;
            while (x < 30*dy){
                this.line(x, j*dy, x+len, j*dy);
                x += 2*len;
            }
        }
        g2D.setColor(new Color(0, 0, 0));
    }



    // simple figures
    public void dot(int x, int y) {g2D.drawOval(x-2, y-2, 4, 4);}
    public void dot(Point p) {this.dot(p.x, p.y);}

    public void circle(int x, int y, int d) {
        this.circle(new Point(x, y), d);
    }
    public void circle(Point p, int d) {
        g2D.drawOval(p.x, p.y, d, d);
    }

    public void square(int x, int y, int size) {
        this.rect(new Point(x, y), size, size);
    }
    public void square(Point p, int size) {g2D.drawRect(p.x, p.y, size, size);}

    public void rect(int x, int y, int sizeX, int sizeY) {
        this.rect(new Point(x, y), sizeX, sizeY);
    }
    public void rect(Point p, int sizeX, int sizeY) {g2D.drawRect(p.x, p.y, sizeX, sizeY);}

    public void line(int x1, int y1, int x2, int y2) {
        this.line(new Line(x1, y1, x2, y2));
    }
    public void line(Point p1, Point p2) {
        this.line(new Line(p1, p2));
    }
    public void line(Line l) {
        g2D.drawLine(l.p1.x, l.p1.y, l.p2.x, l.p2.y);
    }



    // auxiliary methods
    public void connectDots(int x1, int y1, int x2, int y2, boolean up) {
        if (up) {
            this.line(x1, y1, x2, y1);
            this.line(x2, y1, x2, y2);
        } else {
            this.line(x1, y1, x1, y2);
            this.line(x1, y2, x2, y2);
        }
    }
    public void contact(int x, int y, String name) {
        g2D.drawString(name, x+5, y-5);
        this.dot(x, y);
        Line cross = new Line(x-5, y, x+5, y);
        this.line(cross.rotate(-45.0, x, y));
    }

    // electric elements
    public void pnp(int x, int y, int size, double angle, boolean leftEmit, String name){

        int X = x+size/2, Y = y+size/2;

        if (this.drawBoxes) this.square(x, y, size);
        if (this.drawCircles) this.circle((int) (x+0.1*size), (int) (y+0.1*size), (int) (0.8*size));

        // transistor name
        Point nameP = new Point((int) (x+0.425*size), (int) (y+0.7*size)).rotate(angle, X, Y);
        g2D.drawString(name, nameP.x, nameP.y);

        // channel draw
        Line chan = new Line((int) (x+0.2*size), (int) (y+0.35*size),    (int) (x+0.8*size), (int) (y+0.35*size));
        this.line(chan.rotate(angle, X, Y));

        // base drawing
        Line base = new Line((int) (x+0.5*size), y,   (int) (x+0.5*size), (int) (y+0.35*size));
        this.line(base.rotate(angle, X, Y));

        // emitter+collector draw
        // left
        Line con1 = new Line((int) (x+0.35*size), (int) (y+0.35*size),    (int) (x+0.15*size), (int) (y+0.7*size));
        Line conn1 = new Line((int) (x+0.15*size), (int) (y+0.7*size),    x, (int) (y+0.7*size));
        this.line(con1.rotate(angle, X, Y));
        this.line(conn1.rotate(angle, X, Y));
        // right
        Line con2 = new Line((int) (x+0.65*size), (int) (y+0.35*size),    (int) (x+0.85*size), (int) (y+0.7*size));
        Line conn2 = new Line((int) (x+0.85*size), (int) (y+0.7*size),    x+size, (int) (y+0.7*size));
        this.line(con2.rotate(angle, X, Y));
        this.line(conn2.rotate(angle, X, Y));

        // connection dots
        if (drawContacts) {
            Point conEmCon1 = new Point(x, (int) (y+0.7*size));
            Point conEmCon2 = new Point(x+size, (int) (y+0.7*size));
            Point conBase = new Point((int) (x+0.5*size), y);
            this.dot(conBase.rotate(angle, X, Y));
            this.dot(conEmCon1.rotate(angle, X, Y));
            this.dot(conEmCon2.rotate(angle, X, Y));
        }


        // draw emitter pointer
        Line emitter1, emitter2;
        if (leftEmit) {
            emitter1 = new Line((int) (x+0.35*size), (int) (y+0.35*size),   (int) (x+0.33*size), (int) (y+0.46*size));
            emitter2 = new Line((int) (x+0.35*size), (int) (y+0.35*size),   (int) (x+0.26*size), (int) (y+0.43*size));
        } else {
            emitter1 = new Line((int) (x+0.65*size), (int) (y+0.35*size),   (int) (x+0.67*size), (int) (y+0.46*size));
            emitter2 = new Line((int) (x+0.65*size), (int) (y+0.35*size),   (int) (x+0.74*size), (int) (y+0.43*size));
        }
        this.line(emitter1.rotate(angle, X, Y));
        this.line(emitter2.rotate(angle, X, Y));
    }
    public void npn(int x, int y, int size, double angle, boolean leftEmit, String name){

        int X = x+size/2, Y = y+size/2;

        if (this.drawBoxes) this.square(x, y, size);
        if (this.drawCircles) this.circle((int) (x+0.1*size), (int) (y+0.1*size), (int) (0.8*size));

        // transistor name
        Point nameP = new Point((int) (x+0.425*size), (int) (y+0.6*size)).rotate(angle, X, Y);
        g2D.drawString(name, nameP.x, nameP.y);

        // channel draw
        Line chan = new Line((int) (x+0.2*size), (int) (y+0.35*size),    (int) (x+0.8*size), (int) (y+0.35*size));
        this.line(chan.rotate(angle, X, Y));

        // base drawing
        Line base = new Line((int) (x+0.5*size), y,   (int) (x+0.5*size), (int) (y+0.35*size));
        this.line(base.rotate(angle, X, Y));

        // emitter+collector draw
        // left
        Line con1 = new Line((int) (x+0.35*size), (int) (y+0.35*size),    (int) (x+0.15*size), (int) (y+0.7*size));
        Line conn1 = new Line((int) (x+0.15*size), (int) (y+0.7*size),    x, (int) (y+0.7*size));
        this.line(con1.rotate(angle, X, Y));
        this.line(conn1.rotate(angle, X, Y));
        // right
        Line con2 = new Line((int) (x+0.65*size), (int) (y+0.35*size),    (int) (x+0.85*size), (int) (y+0.7*size));
        Line conn2 = new Line((int) (x+0.85*size), (int) (y+0.7*size),    x+size, (int) (y+0.7*size));
        this.line(con2.rotate(angle, X, Y));
        this.line(conn2.rotate(angle, X, Y));

        // connection dots
        if (drawContacts) {
            Point conEmCon1 = new Point(x, (int) (y+0.7*size));
            Point conEmCon2 = new Point(x+size, (int) (y+0.7*size));
            Point conBase = new Point((int) (x+0.5*size), y);
            this.dot(conBase.rotate(angle, X, Y));
            this.dot(conEmCon1.rotate(angle, X, Y));
            this.dot(conEmCon2.rotate(angle, X, Y));
        }


        // draw emitter pointer
        Line emitter1, emitter2;
        if (leftEmit) {
            emitter1 = new Line((int) (x+0.15*size), (int) (y+0.7*size),   (int) (x+0.23*size), (int) (y+0.63*size));
            emitter2 = new Line((int) (x+0.15*size), (int) (y+0.7*size),   (int) (x+0.17*size), (int) (y+0.59*size));
        } else {
            emitter1 = new Line((int) (x+0.85*size), (int) (y+0.7*size),   (int) (x+0.77*size), (int) (y+0.63*size));
            emitter2 = new Line((int) (x+0.85*size), (int) (y+0.7*size),   (int) (x+0.83*size), (int) (y+0.59*size));
        }
        this.line(emitter1.rotate(angle, X, Y));
        this.line(emitter2.rotate(angle, X, Y));
    }
    public void res(int x, int y, int size, double angle) {
        int X = x+size/2, Y = y+size/2;

        if (this.drawBoxes) this.square(x, y, size);

        if (drawContacts) {
            Point conn1 = new Point(x, (int) (y+0.5*size)).rotate(angle, X, Y);
            Point conn2 = new Point(x+size, (int) (y+0.5*size)).rotate(angle, X, Y);
            this.dot(conn1);
            this.dot(conn2);
        }

        Line con1 = new Line(x, (int) (y+0.5*size),   (int) (x+0.2*size), (int) (y+0.5*size)).rotate(angle, X, Y);
        Line con2 = new Line((int) (x+0.8*size), (int) (y+0.5*size),   x+size, (int) (y+0.5*size)).rotate(angle, X, Y);
        this.line(con1);
        this.line(con2);

        Line res1 = new Line((int) (x+0.2*size), (int) (y+0.4*size),   (int) (x+0.2*size), (int) (y+0.6*size)).rotate(angle, X, Y);
        Line res2 = new Line((int) (x+0.2*size), (int) (y+0.4*size),   (int) (x+0.8*size), (int) (y+0.4*size)).rotate(angle, X, Y);
        Line res3 = new Line((int) (x+0.2*size), (int) (y+0.6*size),   (int) (x+0.8*size), (int) (y+0.6*size)).rotate(angle, X, Y);
        Line res4 = new Line((int) (x+0.8*size), (int) (y+0.4*size),   (int) (x+0.8*size), (int) (y+0.6*size)).rotate(angle, X, Y);
        this.line(res1);
        this.line(res2);
        this.line(res3);
        this.line(res4);
    }
    public void cap(int x, int y, int size, double angle) {
        int X = x+size/2, Y = y+size/2;

        if (this.drawBoxes) this.square(x, y, size);

        if (drawContacts) {
            Point conn1 = new Point(x, (int) (y+0.5*size)).rotate(angle, X, Y);
            Point conn2 = new Point(x+size, (int) (y+0.5*size)).rotate(angle, X, Y);
            this.dot(conn1);
            this.dot(conn2);
        }

        Line con1 = new Line(x, (int) (y+0.5*size),   (int) (x+0.45*size), (int) (y+0.5*size)).rotate(angle, X, Y);
        this.line(con1);

        Line con2 = new Line((int) (x+0.55*size), (int) (y+0.5*size),   x+size, (int) (y+0.5*size)).rotate(angle, X, Y);
        this.line(con2);

        Line cap1 = new Line((int) (x+0.45*size), (int) (y+0.3*size),   (int) (x+0.45*size), (int) (y+0.7*size)).rotate(angle, X, Y);
        Line cap2 = new Line((int) (x+0.55*size), (int) (y+0.3*size),   (int) (x+0.55*size), (int) (y+0.7*size)).rotate(angle, X, Y);
        this.line(cap1);
        this.line(cap2);
    }



}
