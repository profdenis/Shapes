package v5.shapes;

import java.awt.Color;

public class PolyLine extends Shape {
    private Point[] points;

    public PolyLine(Point[] points) {
        this(points, defaultDrawColor);
    }

    public PolyLine(Point[] points, Color drawColor) {
        super(drawColor);
        this.points = points;
        this.drawColor = drawColor;
    }

    public PolyLine(PolyLine other) {
        this(other.points, other.drawColor);
        this.points = new Point[other.points.length];
        System.arraycopy(other.points, 0, this.points, 0, other.points.length);
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public void draw(Image image) {
        for (int i = 1; i < points.length; i++) {
            new Line(points[i - 1], points[i], drawColor).draw(image);
        }
    }


}
