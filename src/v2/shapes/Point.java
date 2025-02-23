package v2.shapes;

import java.awt.Color;

public class Point {

    public static final Color defaultDrawColor = Color.BLACK;

    private int x;
    private int y;

    private Color drawColor;


    public Point(int x, int y) {
        this(x, y, defaultDrawColor);
    }

    public Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.drawColor = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void draw(Image image) {
        image.setPixel(x, y, drawColor);
    }
}
