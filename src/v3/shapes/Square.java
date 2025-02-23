package v3.shapes;

import java.awt.Color;

public class Square extends Shape {

    private Point topLeft;
    private int width;

    public Square(Point topLeft, int width) {
        this(topLeft, width, defaultDrawColor);
    }

    public Square(Point topLeft, int width, Color drawColor) {
        super(drawColor);
        this.topLeft = topLeft;
        this.width = width;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void draw(Image image) {
        //noinspection SuspiciousNameCombination
        new Rectangle(topLeft, width, width, drawColor).draw(image);
    }
}
