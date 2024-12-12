package v5;

import v5.shapes.*;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        int width = 200;
        Image image = new Image(width);

        for (int i = 0; i < 200; i++) {
            v5.shapes.Point p = new v5.shapes.Point(i, i, Color.BLUE);
            p.Draw(image);
        }

        HLine hline = new HLine(new Point(10, 10), 120, Color.RED);
        hline.Draw(image);

        Line line1 = new Line(new Point(20, 20), new Point(50, 120), Color.GREEN);
        line1.Draw(image);

        image.Save("test.png");
    }
}