package v5.shapes;

import java.awt.Color;

public class Point extends Shape {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("X cannot be negative");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("X cannot be negative");
        }
        this.y = y;
    }


    public Point(int x, int y, Color drawColor) {
        super(drawColor);
        setX(x);
        setY(y);
    }

    public Point(int x, int y) {
        this(x, y, v5.shapes.Shape.defaultDrawColor);
    }

    public Point(Point p) {
        this(p.x, p.y, p.drawColor);
    }

    public void Draw(Image image) {
        image.SetPixel(x, y, drawColor);
    }
}