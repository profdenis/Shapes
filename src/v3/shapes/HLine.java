package v3.shapes;

import java.awt.Color;

public class HLine extends Shape {
    private Point start;
    private int width;

    public HLine(Point start, int width) {
        this(start, width, defaultDrawColor);
    }

    public HLine(Point start, int width, Color drawColor) {
        super(drawColor);
        this.start = start;
        this.width = width;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void draw(Image image) {
        for (int i = 0; i < width; i++) {
            new Point(start.getX() + i, start.getY(), drawColor).draw(image);
        }
    }
}