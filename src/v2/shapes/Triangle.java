package v2.shapes;

import java.awt.Color;

public class Triangle {

    private static final Color defaultDrawColor = Color.BLACK;

    private Point a;
    private Point b;
    private Point c;

    private Color drawColor;

    public Triangle(Point a, Point b, Point c) {
        this(a, b, c, defaultDrawColor);
    }

    public Triangle(Point a, Point b, Point c, Color drawColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.drawColor = drawColor;
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

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void Draw(Image image) {
        new Line(a, b, drawColor).Draw(image);
        new Line(b, c, drawColor).Draw(image);
        new Line(c, a, drawColor).Draw(image);
    }
}