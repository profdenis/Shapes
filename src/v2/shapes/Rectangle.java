package v2.shapes;

import java.awt.*;

public class Rectangle {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point topLeft;
    private int width;
    private int height;

    private Color drawColor;

    public Rectangle(Point topLeft, int width, int height) {
        this(topLeft, width, height, defaultDrawColor);
    }

    public Rectangle(Point topLeft, int width, int height, Color drawColor) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
        this.drawColor = drawColor;
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

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void Draw(Image image) {
        new VLine(topLeft, height, drawColor).Draw(image);
        new HLine(topLeft, width, drawColor).Draw(image);
        new VLine(new Point(topLeft.getX() + width, topLeft.getY()), height, drawColor).Draw(image);
        new HLine(new Point(topLeft.getX(), topLeft.getY() + height), width, drawColor).Draw(image);
    }
}
