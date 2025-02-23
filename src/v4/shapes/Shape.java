package v4.shapes;

import java.awt.Color;

public abstract class Shape
{
    public static Color defaultDrawColor = Color.BLACK;
    public Color drawColor;

    protected Shape(Color drawColor)
    {
        this.drawColor = drawColor;
    }
    
    protected Shape()
    {
        this(defaultDrawColor);
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public abstract void draw(Image image);
}