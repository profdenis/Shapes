package v4.shapes;

import java.awt.Color;

public class Square extends Rectangle {

    public Square(Point topLeft, int width) {
        this(topLeft, width, defaultDrawColor);
    }

    public Square(Point topLeft, int width, Color drawColor) {
        super(topLeft, width, width, drawColor);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }

    public void draw(Image image) {
        super.draw(image);
    }
}
