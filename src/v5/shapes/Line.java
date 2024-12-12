package v5.shapes;

import java.awt.Color;

public class Line extends Shape {
    private Point start;
    private v5.shapes.Point end;

    public Line(v5.shapes.Point start, v5.shapes.Point end, Color drawColor) {
        super(drawColor);
        this.start = start;
        this.end = end;
    }

    public Line(v5.shapes.Point start, v5.shapes.Point end) {
        this(start, end, v5.shapes.Shape.defaultDrawColor);
    }

    public Line(Line line) {
        this(line.start, line.end, line.drawColor);
    }

    public v5.shapes.Point getStart() {
        return start;
    }

    public void setStart(v5.shapes.Point start) {
        this.start = start;
    }

    public v5.shapes.Point getEnd() {
        return end;
    }

    public void setEnd(v5.shapes.Point end) {
        this.end = end;
    }

    public void Draw(Image image) {
        int startX = start.getX();
        int endX = end.getX();
        int startY = start.getY();
        int endY = end.getY();

        // ligne verticale, il faut éviter une division par 0
        if (startY == endY) {
            drawHorizontalLine(image, startX, startY, endY);
            return;
        }

        // éviter une division int/int qui entraînerait une imprécision
        double slope = (endY - startY) / (double) (endX - startX);
        double intercept = endY - slope * endX;

        if (Math.abs(slope) < 1) {
            drawCloserToHorizontal(image, startX, endX, slope, intercept);
        } else {
            drawCloserToVertical(image, startY, endY, intercept, slope);
        }
    }

    private void drawCloserToVertical(Image image, int startY, int endY, double intercept, double slope) {
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        for (int y = minY; y <= maxY; y++) {
            int x = (int) Math.round((y - intercept) / slope);
            image.SetPixel(x, y, drawColor);
        }
    }

    private void drawCloserToHorizontal(Image image, int startX, int endX, double slope, double intercept) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);

        for (int x = minX; x <= maxX; x++) {
            int y = (int) Math.round(slope * x + intercept);
            image.SetPixel(x, y, drawColor);
        }
    }

    private void drawHorizontalLine(Image image, int startX, int startY, int endY) {
        v5.shapes.Point temp = new v5.shapes.Point(startX, Math.min(startY, endY));
        int width = Math.abs(endY - startY) + 1;

        if (temp.getX() >= 0 && temp.getX() < image.width) {
            for (int j = Math.max(temp.getY(), 0); j < temp.getY() + width && j < image.height; j++) {
                image.SetPixel(temp.getX(), j, drawColor);
            }
        }
    }
}