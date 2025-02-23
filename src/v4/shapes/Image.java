package v4.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    public static int defaultWidth = 100;
    public static int defaultHeight = 100;
    public static Color defaultBackgroundColor = Color.WHITE;

    public int width;
    public int height;
    public Color backgroundColor;
    public BufferedImage bufferedImage;

    public Image() {
        this(defaultWidth, defaultHeight, defaultBackgroundColor);
    }

    public Image(int width) {
        //noinspection SuspiciousNameCombination
        this(width, width, defaultBackgroundColor);
    }

    public Image(int width, int height) {
        this(width, height, defaultBackgroundColor);
    }


    public Image(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        clear(this.backgroundColor);
    }

    public void clear(Color clearColor) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                setPixel(i, j, clearColor);
            }
        }
    }

    public Color getPixel(int x, int y) {
        if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
            return getPixel(x, y);
        }
        // throw exception?
        return backgroundColor;
    }

    public void setPixel(int x, int y, Color drawColor) {
        if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
            bufferedImage.setRGB(x, y, drawColor.getRGB());
        }
    }

    public void save(String filename) {
        try {
            File outputFile = new File(filename);
            ImageIO.write(bufferedImage, "PNG", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}