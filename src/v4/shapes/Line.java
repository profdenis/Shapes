package v4.shapes;

import java.awt.Color;

public class Line extends Shape {
    protected Point start;
    protected Point end;

    public Line(Point start, Point end, Color drawColor) {
        super(drawColor);
        this.start = start;
        this.end = end;
    }

    public Line(Point start, Point end) {
        this(start, end, Shape.defaultDrawColor);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void draw(Image image) {
        System.out.println("Drawing line from " + start + " to " + end);
        int startX = start.getX();
        int endX = end.getX();
        int startY = start.getY();
        int endY = end.getY();

        // ligne verticale, il faut éviter une division par 0
        if (startX == endX) {
            drawVerticalLine(image, startX, startY, endY);
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
            image.setPixel(x, y, drawColor);
        }
    }

    private void drawCloserToHorizontal(Image image, int startX, int endX, double slope, double intercept) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);

        for (int x = minX; x <= maxX; x++) {
            int y = (int) Math.round(slope * x + intercept);
            image.setPixel(x, y, drawColor);
        }
    }

    private void drawVerticalLine(Image image, int startX, int startY, int endY) {
        Point temp = new Point(startX, Math.min(startY, endY));
        int width = Math.abs(endY - startY) + 1;

        if (temp.getX() >= 0 && temp.getX() < image.width) {
            for (int j = Math.max(temp.getY(), 0); j < temp.getY() + width && j < image.height; j++) {
                image.setPixel(temp.getX(), j, drawColor);
            }
        }
    }

//    public void draw(Image image) {
//        // ligne verticale, il faut éviter une division par 0
//        if (start.getX() == end.getX()) {
//            VLine vline = new VLine(start, Math.abs(end.getY() - start.getY()) + 1, drawColor);
//            vline.draw(image);
//            return;
//        }
//
//        // éviter une division int/int qui entraînerait une imprécision
//        double slope = (end.getY() - start.getY()) / (double) (end.getX() - start.getX());
//        double intercept = end.getY() - slope * end.getX();
//
//        if (Math.abs(slope) < 1) {
//            drawCloserToHorizontal(image, start.getX(), end.getX(), slope, intercept, drawColor);
//        } else {
//            drawCloserToVertical(image, start.getY(), end.getY(), intercept, slope, drawColor);
//        }
//    }
//
//    private static void drawCloserToVertical(Image image, int startY, int endY, double intercept, double slope, Color color) {
//        int minY = Math.min(startY, endY);
//        int maxY = Math.max(startY, endY);
//
//        for (int y = minY; y <= maxY; y++) {
//            int x = (int) Math.round((y - intercept) / slope);
//            image.setPixel(x, y, color);
//        }
//    }
//
//    private static void drawCloserToHorizontal(Image image, int startX, int endX, double slope, double intercept, Color color) {
//        int minX = Math.min(startX, endX);
//        int maxX = Math.max(startX, endX);
//
//        for (int x = minX; x <= maxX; x++) {
//            int y = (int) Math.round(slope * x + intercept);
//            image.setPixel(x, y, color);
//        }
//    }
}