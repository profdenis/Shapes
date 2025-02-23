package v5.shapes;

import java.awt.Color;

public class VLine extends Line {
    private int height;

    public VLine(Point start, int height, Color drawColor) {
        super(start, new Point(start.getX(), start.getY() + height - 1), drawColor);
        setHeight(height);
    }

    public VLine(Point start, int width) {
        this(start, width, Shape.defaultDrawColor);
    }
    
    public VLine(VLine other) {
        super(other.getStart(), other.getEnd(), other.getDrawColor());
        this.height = other.height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Width cannot be negative");
        }
        this.height = height;
//        super.setEnd(new Point(super.getEnd().getX(), super.getEnd().getY() + height - 1));
    }


}