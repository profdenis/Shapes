package v2.shapes;

import java.awt.*;

public class Square {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point topLeft;
    private int width;

    private Color drawColor;

    public Square(Point topLeft, int width) {
        this(topLeft, width, defaultDrawColor);
    }

    public Square(Point topLeft, int width, Color drawColor) {
        this.topLeft = topLeft;
        this.width = width;
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

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void Draw(Image image) {
        //noinspection SuspiciousNameCombination
        new Rectangle(topLeft, width, width, drawColor).Draw(image);
    }
}
