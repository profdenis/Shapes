package v2.shapes;

import java.awt.Color;

public class VLine {
    public static final Color defaultDrawColor = Color.BLACK;

    private Point start;
    private int height;
    private Color drawColor;

    public VLine(Point start, int height) {
        this(start, height, defaultDrawColor);
    }

    public VLine(Point start, int height, Color drawColor) {
        this.start = start;
        this.height = height;
        this.drawColor = drawColor;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }


    public void Draw(Image image) {
        for (int j = 0; j < height; j++) {
            new Point(start.getX(), start.getY() + j, drawColor).Draw(image);
        }
    }
}
