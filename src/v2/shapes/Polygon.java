package v2.shapes;

import java.awt.*;

public class Polygon {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point[] points;

    private Color drawColor;

    public Polygon(Point[] points) {
        this(points, defaultDrawColor);
    }

    public Polygon(Point[] points, Color drawColor) {
        this.points = points;
        this.drawColor = drawColor;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public void draw(Image image) {
        new PolyLine(points, drawColor).draw(image);
        new Line(points[0], points[points.length - 1], drawColor).draw(image);
    }


}
