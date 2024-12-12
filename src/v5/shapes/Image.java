package v5.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    public static int defaultWidth = 100;
    public static int defaultHeight = 100;
    public static Color defaultBackgroundColor = Color.BLACK;

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
        Clear(this.backgroundColor);
    }

    public void Clear(Color clearColor) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                SetPixel(i, j, clearColor);
            }
        }
    }

    public Color GetPixel(int x, int y) {
        if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
            return GetPixel(x, y);
        }
        // throw exception?
        return backgroundColor;
    }

    public void SetPixel(int x, int y, Color drawColor) {
        if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
            bufferedImage.setRGB(x, y, drawColor.getRGB());
        }
    }

    public void Save(String filename) {
        try {
            File outputFile = new File(filename);
            ImageIO.write(bufferedImage, "PNG", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}