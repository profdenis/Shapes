package v4.shapes;

import java.awt.Color;

public class HLine extends Line {
    private int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative");
        }
        this.width = width;
//        setEnd(new Point(start.getX() + width - 1, start.getY()));
    }

    public HLine(Point start, int width, Color drawColor) {
        super(start, new Point(start.getX() + width - 1, start.getY()), drawColor);
        setWidth(width);
    }

    public HLine(Point start, int width) {
        this(start, width, v5.shapes.Shape.defaultDrawColor);
    }
}