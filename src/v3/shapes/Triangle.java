package v3.shapes;

import java.awt.*;

public class Triangle extends Shape {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this(a, b, c, defaultDrawColor);
    }

    public Triangle(Point a, Point b, Point c, Color drawColor) {
        super(drawColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public void draw(Image image) {
        new Line(a, b, drawColor).draw(image);
        new Line(b, c, drawColor).draw(image);
        new Line(c, a, drawColor).draw(image);
    }
}
