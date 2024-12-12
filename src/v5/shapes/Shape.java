package v5.shapes;

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

    public abstract void Draw(Image image);
}