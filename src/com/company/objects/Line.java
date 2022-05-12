package com.company.objects;

public class Line {

    public Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = new Point(p1.x, p1.y);
        this.p2 = new Point(p2.x, p2.y);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Line rotate(double angle, int cx, int cy) {
        this.p1.rotate(angle, cx, cy);
        this.p2.rotate(angle, cx, cy);
        return this;
    }

    public Line rotate(double angle) {
        this.rotate(angle, 0, 0);
        return this;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
