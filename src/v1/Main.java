package v1;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        Shapes.drawPoint(10, 200);
        Shapes.drawHorizontalLine(10, 100, 100, Color.BLUE);
        Shapes.drawLine(20, 20, 30, 200, Color.RED);
        Shapes.drawLine(30, 30, 200, 40, Color.GREEN);
        Shapes.drawLine(40, 40, 40, 100, Color.YELLOW);
        Shapes.drawLine(50, 50, 200, 50, Color.CYAN);
        Shapes.drawTriangle(25, 250, 200, 200, 100, 300);
        Shapes.drawRectangle(100, 120, 220, 150, Color.MAGENTA);
        Shapes.drawSquare(300, 10, 40, Color.DARK_GRAY);
        Shapes.drawCircle(150, 150, 100, Color.ORANGE);
        int[] x_values = {10, 200, 60, 300, 50};
        int[] y_values = {310, 335, 370, 340, 399};
//        Shapes.drawPolyLine(x_values, y_values, Color.PINK );
        Shapes.drawPolygon(x_values, y_values, Color.PINK );
        Shapes.image.Save("test1.png");
    }
}
