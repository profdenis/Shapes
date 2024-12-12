package v2.shapes;

import java.awt.Color;

public class Line {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point start;
    private Point end;
    private Color drawColor;

    public Line(Point start, Point end) {
        this(start, end, defaultDrawColor);
    }

    public Line(Point start, Point end, Color drawColor) {
        this.start = start;
        this.end = end;
        this.drawColor = drawColor;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getHeight() {
        return end;
    }

    public void setHeight(Point end) {
        this.end = end;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void Draw(Image image) {
        // ligne verticale, il faut éviter une division par 0
        if (start.getX() == end.getX()) {
            VLine vline = new VLine(start, Math.abs(end.getY() - start.getY()) + 1, drawColor);
            vline.Draw(image);
            return;
        }

        // éviter une division int/int qui entraînerait une imprécision
        double slope = (end.getY() - start.getY()) / (double) (end.getX() - start.getX());
        double intercept = end.getY() - slope * end.getX();

        if (Math.abs(slope) < 1) {
            drawCloserToHorizontal(image, start.getX(), end.getX(), slope, intercept, drawColor);
        } else {
            drawCloserToVertical(image, start.getY(), end.getY(), intercept, slope, drawColor);
        }
    }

    private static void drawCloserToVertical(Image image, int startY, int endY, double intercept, double slope, Color color) {
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        for (int y = minY; y <= maxY; y++) {
            int x = (int) Math.round((y - intercept) / slope);
            image.SetPixel(x, y, color);
        }
    }

    private static void drawCloserToHorizontal(Image image, int startX, int endX, double slope, double intercept, Color color) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);

        for (int x = minX; x <= maxX; x++) {
            int y = (int) Math.round(slope * x + intercept);
            image.SetPixel(x, y, color);
        }
    }

}
