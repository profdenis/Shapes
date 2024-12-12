package v2.shapes;

import java.awt.Color;

public class PolyLine {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point[] points;

    private Color drawColor;

    public PolyLine(Point[] points) {
        this(points, defaultDrawColor);
    }

    public PolyLine(Point[] points, Color drawColor) {
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

    public void Draw(Image image) {
        for (int i = 1; i < points.length; i++) {
            new Line(points[i - 1], points[i], drawColor).Draw(image);
        }
    }


}
