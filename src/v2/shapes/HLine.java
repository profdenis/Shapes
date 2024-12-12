package v2.shapes;

import java.awt.Color;

public class HLine {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point start;
    private int width;
    private Color drawColor;

    public HLine(Point start, int width) {
        this(start, width, defaultDrawColor);
    }

    public HLine(Point start, int width, Color drawColor) {
        this.start = start;
        this.width = width;
        this.drawColor = drawColor;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }


    public void Draw(Image image) {
        for (int i = 0; i < width; i++) {
            new Point(start.getX() + i, start.getY(), drawColor).Draw(image);
        }
    }
}
