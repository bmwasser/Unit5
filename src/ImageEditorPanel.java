import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageEditorPanel extends JPanel implements KeyListener{

    Color[][] pixels;
    
    public ImageEditorPanel() {
        BufferedImage imageIn = null;
        try {
            // the image should be in the main project folder, not in \src or \bin
            imageIn = ImageIO.read(new File("ScroogeMcDuck.jpg"));
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        pixels = makeColorArray(imageIn);
        setPreferredSize(new Dimension(pixels[0].length, pixels.length));
        setBackground(Color.BLACK);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        // paints the array pixels onto the screen
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                g.setColor(pixels[row][col]);
                g.fillRect(col, row, 1, 1);
            }
        }
    }

    public void run() {
        // call your image-processing methods here OR call them from keyboard event handling methods
        // write image-processing methods as pure functions - for example: pixels = flip(pixels);
        //pixels = flipHorizontal(pixels);
        //pixels = flipVertical(pixels);
        //pixels = grayscale(pixels);
        //pixels = blur(pixels);
        //pixels = swapColor(pixels);
        //if (filter == 1){
            //pixels = flipVertical(pixels);
            //repaint(); 
        //}
    }

    public Color[][] flipHorizontal(Color[][] orig){
        Color[][] changed = new Color[orig.length][orig[0].length];
        for (int r = 0; r < orig.length; r++){
            for (int c = 0; c < orig[0].length; c++){
                changed[r][orig[0].length - c - 1] = orig[r][c];
            }
        }

        return changed;
    }

    public Color[][] flipVertical(Color[][] orig){
        Color[][] changed = new Color[orig.length][orig[0].length];
        for (int c = 0; c < orig[0].length; c++){
            for (int r = 0; r < orig.length; r++){
                changed[orig.length - r - 1][c] = orig[r][c];
            }
        }


        return changed;
    }

    public Color[][] grayscale(Color[][] orig){
        Color[][] changed = new Color[orig.length][orig[0].length];
        for (int r = 0; r < orig.length; r++){
            for (int c = 0; c < orig[0].length; c++){
                Color oldColor = orig[r][c];
                double red = oldColor.getRed() * 0.299;
                double green = oldColor.getGreen() * 0.587;
                double blue = oldColor.getBlue() * 0.114;
                int grayscale = (int) (red + green + blue);
                Color newColor = new Color(grayscale,grayscale,grayscale);
                changed[r][c] = newColor;
            }
        }

        return changed;
    }

    public Color[][] blur(Color[][] orig){
        Color[][] changed = new Color [orig.length][orig[0].length];
        for (int r = 0; r < orig.length; r++){
            for (int c = 0; c < orig[0].length; c++){
                int pixelCount = 0;
                int red = 0;
                int green = 0;
                int blue = 0;
                for (int i = r - 1; i <= r + 1; i++){ //traverse the neighbors along with checking borders
                    for (int j = c - 1; j <= c + 1; j++){
                        if (i >= 0 && j >= 0 && i < orig.length && j < orig[0].length){
                            Color neighbor = orig[i][j];
                            red += neighbor.getRed();
                            green += neighbor.getGreen();
                            blue += neighbor.getBlue();
                            pixelCount++;
                        }
                    }
                }
                red = red / pixelCount;
                green = green / pixelCount;
                blue = blue / pixelCount;
                Color blurred = new Color(red,green,blue);
                changed[r][c] = blurred;
            }
        }

        return changed;
    }

    public Color[][] swapColor(Color[][] orig){
        Color[][] changed = new Color[orig.length][orig[0].length];
        for (int r = 0; r < orig.length; r++){
            for (int c = 0; c < orig[0].length; c++){
                Color oldColor = orig[r][c];
                int red = oldColor.getBlue();
                int green = oldColor.getRed();
                int blue = oldColor.getGreen();
                Color newColor = new Color(red,green,blue);
                changed[r][c] = newColor;
            }
        }

        return changed;


    }

    public Color[][] vintage(Color[][] orig){
        Color[][] changed = new Color[orig.length][orig[0].length];
        for (int r = 0; r < orig.length; r++){
            for (int c = 0; c < orig[0].length; c++){
                Color oldColor = orig[r][c];
                int red = oldColor.getBlue();
                int green = oldColor.getRed();
                int blue = oldColor.getGreen();
                int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
                int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
                int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);
                red = Math.min(newRed, 255);
                green = Math.min(newGreen, 255);
                blue = Math.min(newBlue, 255);
                
                Color newColor = new Color(red,green,blue);
                changed[r][c] = newColor;
            }
        }

        return changed;

    }

    public Color[][] posterize(Color[][] orig){
       Color[] posterColors = {
            new Color(255, 255, 255), // White (Feathers)
            new Color(244, 17, 17),   // Red (Coat)
            new Color(255, 219, 0),   // Yellow (Bill/Coins)
            new Color(0, 0, 0)        // Black (Outlines)
        };

        Color[][] changed = new Color[orig.length][orig[0].length];

        for (int r = 0; r < orig.length; r++) {
            for (int c = 0; c < orig[0].length; c++) {
                Color originalColor = pixels[r][c];

                int minDistance = Integer.MAX_VALUE;
                Color closestColor = posterColors[0]; 

                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();

                for (Color paletteColor : posterColors) {
                    int paletteRed = paletteColor.getRed();
                    int paletteGreen = paletteColor.getGreen();
                    int paletteBlue = paletteColor.getBlue();

                    int dr = red - paletteRed;
                    int dg = green - paletteGreen;
                    int db = blue - paletteBlue;

                    int distance = dr * dr + dg * dg + db * db;

                    if (distance < minDistance) {
                        minDistance = distance;
                        closestColor = paletteColor;
                    }
                }
                
                changed[r][c] = closestColor;
            }
        }

        return changed;

    }


    public Color[][] makeColorArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color[][] result = new Color[height][width];
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color c = new Color(image.getRGB(col, row), true);
                result[row][col] = c;
            }
        }
        // System.out.println("Loaded image: width: " +width + " height: " + height);
        return result;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // call event handling methods
            // use sysouts for debugging like this:
            // System.out.println("The left arrow was pressed");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // call event handling methods
        }
    }
    
    public void keyTyped(KeyEvent e) {
        // note the difference between getKeyChar and getKeyCode
        if (e.getKeyChar() == 'h'){
            pixels = flipHorizontal(pixels);
        }
        if (e.getKeyChar() == 'v'){
            pixels = flipVertical(pixels);
        }
        if (e.getKeyChar() == 'g'){
            pixels = grayscale(pixels);
        }
        if (e.getKeyChar() == 'b'){
            pixels = blur(pixels);
        }
        if (e.getKeyChar() == 's'){
            pixels = swapColor(pixels);
        }
        if (e.getKeyChar() == 'o'){
            pixels = vintage(pixels);
        }
        if (e.getKeyChar() == 'p'){
            pixels = posterize(pixels);
        }
        repaint();
    }
}
