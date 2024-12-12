package v1;

import java.awt.Color;

public class Shapes {
    public static Color defaultColor = Color.BLACK;
    public static Image image = new Image(400);

    public static void drawPoint(int x, int y) {
        drawPoint(x, y, defaultColor);
    }

    public static void drawPoint(int x, int y, Color color) {
        image.SetPixel(x, y, color);
    }

    public static void drawHorizontalLine(int x1, int y1, int width) {
        drawHorizontalLine(x1, y1, width, defaultColor);
    }

    public static void drawHorizontalLine(int x1, int y1, int width, Color color) {
        for (int i = 0; i < width; i++) {
            drawPoint(x1 + i, y1, color);
        }
    }

    public static void drawVerticalLine(int x1, int y1, int height, Color color) {
        for (int j = 0; j < height; j++) {
            drawPoint(x1, y1 + j, color);
        }
    }

    public static void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2, defaultColor);
    }

    public static void drawLine(int x1, int y1, int x2, int y2, Color color) {

        // ligne verticale, il faut éviter une division par 0
        if (x1 == x2) {
            drawVerticalLine(x1, Math.min(y1, y2), Math.abs(y2 - y1) + 1, color);
            return;
        }

        // éviter une division int/int qui entraînerait une imprécision
        double slope = (y2 - y1) / (double) (x2 - x1);
        double intercept = y2 - slope * x2;

        if (Math.abs(slope) < 1) {
            drawCloserToHorizontal(x1, x2, slope, intercept, color);
        } else {
            drawCloserToVertical(y1, y2, intercept, slope, color);
        }
    }

    private static void drawCloserToVertical(int startY, int endY, double intercept, double slope, Color color) {
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        for (int y = minY; y <= maxY; y++) {
            int x = (int) Math.round((y - intercept) / slope);
            image.SetPixel(x, y, color);
        }
    }

    private static void drawCloserToHorizontal(int startX, int endX, double slope, double intercept, Color color) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);

        for (int x = minX; x <= maxX; x++) {
            int y = (int) Math.round(slope * x + intercept);
            image.SetPixel(x, y, color);
        }
    }

    public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        drawTriangle(x1, y1, x2, y2, x3, y3, defaultColor);
    }

    public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        drawLine(x1, y1, x2, y2, color);
        drawLine(x2, y2, x3, y3, color);
        drawLine(x3, y3, x1, y1, color);
    }

    public static void drawRectangle(int x, int y, int width, int height) {
        drawRectangle(x, y, width, height, defaultColor);
    }

    public static void drawRectangle(int x, int y, int width, int height, Color color) {
        drawLine(x, y, x + width, y, color);
        drawLine(x + width, y, x + width, y + height, color);
        drawLine(x + width, y + height, x, y + height, color);
        drawLine(x, y + height, x, y, color);
    }

    public static void drawSquare(int x, int y, int width) {
        drawSquare(x, y, width, defaultColor);
    }

    public static void drawSquare(int x, int y, int width, Color color) {
        //noinspection SuspiciousNameCombination
        drawRectangle(x, y, width, width, color);
    }

    public static void drawPolyLine(int[] x, int[] y) {
        drawPolyLine(x, y, defaultColor);
    }

    public static void drawPolyLine(int[] x, int[] y, Color color) {
        for (int i = 1; i < x.length; i++) {
            drawLine(x[i - 1], y[i - 1], x[i], y[i], color);
        }
    }


    public static void drawPolygon(int[] x, int[] y) {
        drawPolygon(x, y, defaultColor);
    }

    public static void drawPolygon(int[] x, int[] y, Color color) {
        drawPolyLine(x, y, color);
        drawLine(x[0], y[0], x[x.length - 1], y[y.length - 1], color);

    }

    public static void drawCircle(int x, int y, int radius) {
        drawCircle(x, y, radius, defaultColor);
    }

    public static void drawCircle(int x, int y, int radius, Color color) {
        int cos45 = (int) Math.round(radius * Math.cos(Math.PI / 4));

        for (int i = 0; i <= cos45; i++) {
            int j = (int) Math.round(Math.sqrt(radius * radius - i * i));
            image.SetPixel(x + i, y + j, color); // point 1
            image.SetPixel(x - i, y + j, color); // point 2: symétrie du point 1 par rapport à l'axe Y

            image.SetPixel(x + i, y - j, color); // point 3: symétrie du point 1 par rapport à l'axe X
            image.SetPixel(x - i, y - j, color); // point 4: symétrie du point 3 par rapport à l'axe Y

            image.SetPixel(x + j, y + i, color); // point 5: symétrie du point 1 par rapport à la diagonale 45°
            image.SetPixel(x + j, y - i, color); // point 6: symétrie du point 5 par rapport à l'axe X

            image.SetPixel(x - j, y + i, color); // point 7: symétrie du point 5 par rapport à l'axe Y
            image.SetPixel(x - j, y - i, color); // point 8: symétrie du point 7 par rapport à l'axe X
        }
    }
}
