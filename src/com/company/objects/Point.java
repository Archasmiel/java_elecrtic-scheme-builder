package com.company.objects;

public class Point {

    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point rotate(double angle, int cx, int cy) {
        int curX = this.x, curY = this.y;
        double ang = angle*Math.PI/180;
        this.x = (int) ((curX-cx)*Math.cos(ang) - (curY-cy)*Math.sin(ang) + cx);
        this.y = (int) ((curX-cx)*Math.sin(ang) + (curY-cy)*Math.cos(ang) + cy);
        return this;
    }

    public Point rotate(double angle) {
        int curX = this.x, curY = this.y;
        double ang = angle*Math.PI/180;
        this.x = (int) (curX*Math.cos(ang) - curY*Math.sin(ang));
        this.y = (int) (curX*Math.sin(ang) + curY*Math.cos(ang));
        return this;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
