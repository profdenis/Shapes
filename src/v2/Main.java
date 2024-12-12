package v2;

import v2.shapes.*;

import java.awt.Color;

/**
 * The Main class serves as an entry point to demonstrate drawing various shapes 
 * on an image with specified dimensions and colors.
 */
public class Main {
    /**
     * The main method initializes an image, draws various shapes onto it, 
     * and then saves the resulting image to a file.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int width = 400;
        Image image = new Image(width);

        Point p = new Point(10, 50, Color.BLUE);
        p.Draw(image);

        HLine hline = new HLine(new Point(10, 10), 120, Color.RED);
        hline.Draw(image);

        VLine vline = new VLine(new Point(20, 20), 120, Color.PINK);
        vline.Draw(image);

        Line line1 = new Line(new Point(30, 30), new Point(50, 120), Color.GREEN);
        line1.Draw(image);

        Line line2 = new Line(new Point(300, 150), new Point(70, 130), Color.MAGENTA);
        line2.Draw(image);

        Triangle triangle = new Triangle(new Point(25, 250), new Point(200, 200), new Point(100, 300));
        triangle.Draw(image);

        Rectangle rectangle = new Rectangle(new Point(100, 120), 220, 150, Color.MAGENTA);
        rectangle.Draw(image);

        Square square = new Square(new Point(300, 10), 40, Color.GRAY);
        square.Draw(image);

        Circle circle = new Circle(new Point(150, 150), 100, Color.ORANGE);
        circle.Draw(image);

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
        polygon.Draw(image);

        image.Save("test2.png");
    }
}