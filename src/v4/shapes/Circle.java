package v4.shapes;

import java.awt.Color;

public class Circle extends Shape {
    private Point center;
    private int radius;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Point center, int radius, Color drawColor)
    {
        super(drawColor);
        this.center = center;
        this.radius = radius;
    }

    public Circle(Point center, int radius)
    {
        this(center, radius, defaultDrawColor);
    }

    @Override
    public void draw(Image image) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;
        drawCirclePoints(image, center.getX(), center.getY(), x, y);
        while (y >= x) {
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }
            drawCirclePoints(image, center.getX(), center.getY(), x, y);
        }
    }

    private void drawCirclePoints(Image image, int x, int y, int x1, int y1) {
        image.setPixel(x + x1, y + y1, drawColor);
        image.setPixel(x - x1, y + y1, drawColor);
        image.setPixel(x + x1, y - y1, drawColor);
        image.setPixel(x - x1, y - y1, drawColor);
        image.setPixel(x + y1, y + x1, drawColor);
        image.setPixel(x - y1, y + x1, drawColor);
        image.setPixel(x + y1, y - x1, drawColor);
        image.setPixel(x - y1, y - x1, drawColor);
    }
}
