package v2.shapes;

import java.awt.*;

@SuppressWarnings("DuplicatedCode")
public class Circle {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point center;
    private int radius;

    private Color drawColor;

    public Circle(Point center, int radius) {
        this(center, radius, defaultDrawColor);
    }

    public Circle(Point center, int radius, Color drawColor) {
        this.center = center;
        this.radius = radius;
        this.drawColor = drawColor;
    }

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

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void Draw(Image image) {
        int cos45 = (int) Math.round(radius * Math.cos(Math.PI / 4));

        for (int i = 0; i <= cos45; i++) {
            int j = (int) Math.round(Math.sqrt(radius * radius - i * i));
            image.SetPixel(center.getX() + i, center.getY() + j, drawColor); // point 1
            image.SetPixel(center.getX() - i, center.getY() + j, drawColor); // point 2: symétrie du point 1 par rapport à l'axe Y

            image.SetPixel(center.getX() + i, center.getY() - j, drawColor); // point 3: symétrie du point 1 par rapport à l'axe X
            image.SetPixel(center.getX() - i, center.getY() - j, drawColor); // point 4: symétrie du point 3 par rapport à l'axe Y

            image.SetPixel(center.getX() + j, center.getY() + i, drawColor); // point 5: symétrie du point 1 par rapport à la diagonale 45°
            image.SetPixel(center.getX() + j, center.getY() - i, drawColor); // point 6: symétrie du point 5 par rapport à l'acenter.getX()e X

            image.SetPixel(center.getX() - j, center.getY() + i, drawColor); // point 7: symétrie du point 5 par rapport à l'axe Y
            image.SetPixel(center.getX() - j, center.getY() - i, drawColor); // point 8: symétrie du point 7 par rapport à l'axe X
        }
    }
}
