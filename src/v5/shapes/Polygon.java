package v5.shapes;

import java.awt.Color;

public class Polygon extends PolyLine {
    private Point[] points;

    public Polygon(Point[] points) {
        this(points, defaultDrawColor);
    }

    public Polygon(Point[] points, Color drawColor) {
        super(points, drawColor);
        this.points = points;
    }
    
    public Polygon(Polygon other) {
        super(other.points, other.drawColor);
    }

    public void draw(Image image) {
        super.draw(image);
        new Line(points[0], points[points.length - 1], drawColor).draw(image);
    }


}
