package v4.shapes;

import java.awt.Color;

public class Rectangle extends Shape {

    private Point topLeft;
    private int width;
    private int height;

    public Rectangle(Point topLeft, int width, int height) {
        this(topLeft, width, height, defaultDrawColor);
    }

    public Rectangle(Point topLeft, int width, int height, Color drawColor) {
        super(drawColor);
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(Image image) {
        new VLine(topLeft, height, drawColor).draw(image);
        new HLine(topLeft, width, drawColor).draw(image);
        new VLine(new Point(topLeft.getX() + width, topLeft.getY()), height, drawColor).draw(image);
        new HLine(new Point(topLeft.getX(), topLeft.getY() + height), width, drawColor).draw(image);
    }
}
