package v3.shapes;

import java.awt.Color;

public class VLine extends Shape {
    private Point start;
    private int height;

    public VLine(Point start, int height) {
        this(start, height, defaultDrawColor);
    }

    public VLine(Point start, int height, Color drawColor) {
        super(drawColor);
        this.start = start;
        this.height = height;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(Image image) {
        for (int j = 0; j < height; j++) {
            new Point(start.getX(), start.getY() + j, drawColor).draw(image);
        }
    }
}