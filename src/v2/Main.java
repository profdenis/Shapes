package v2;

import v2.shapes.*;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        int width = 400;
        Image image = new Image(width);

        Point p = new Point(10, 50, Color.BLUE);
        p.draw(image);

        HLine hline = new HLine(new Point(10, 10), 120, Color.RED);
        hline.draw(image);

        VLine vline = new VLine(new Point(20, 20), 120, Color.PINK);
        vline.draw(image);

        Line line1 = new Line(new Point(30, 30), new Point(50, 120), Color.GREEN);
        line1.draw(image);

        Line line2 = new Line(new Point(300, 150), new Point(70, 130), Color.MAGENTA);
        line2.draw(image);

        Triangle triangle = new Triangle(new Point(25, 250), new Point(200, 200), new Point(100, 300));
        triangle.draw(image);

        Rectangle rectangle = new Rectangle(new Point(100, 120), 220, 150, Color.MAGENTA);
        rectangle.draw(image);

        Square square = new Square(new Point(300, 10), 40, Color.GRAY);
        square.draw(image);

        Circle circle = new Circle(new Point(150, 150), 100, Color.ORANGE);
        circle.draw(image);

        Point[] points = {
                new Point(10, 310),
                new Point(200, 335),
                new Point(60, 370),
                new Point(300, 340),
                new Point(50, 399)
        };
//        PolyLine polyLine = new PolyLine(points, Color.PINK);
//        polyLine.Draw(image);

        Polygon polygon = new Polygon(points, Color.CYAN);
        polygon.draw(image);

        image.save("test2.png");
    }
}