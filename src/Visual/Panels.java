package Visual;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panels extends JPanel{
    private BufferedImage image;
    private int tileScale = 0;

    Panels () {
    }

    Panels(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
    }

    //Used for centerPanel backgrounds (stretches img to fit)
    public void backGroundImg(String imgPath) {
        this.image = loadImage(imgPath);
        this.tileScale = 0;
        repaint();
    }

    //Repeat img such as sidePanel stone wall texture
    public void tiledBackGroundImg(String imgPath, int scale) {
        this.image = loadImage(imgPath);
        this.tileScale = scale;
        repaint();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Could not load image: " + path);
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) return; //If no picture - stop here

        Graphics2D g2 = (Graphics2D) g; //Graphics2D can handle tiling of pictures (Used for stone wall in sidepanels)
        //NEAREST_NEIGHBOR makes sure that squares line up correctly to display pixel art better
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

        //If tileScale <= 0 then it is a center background and should be stretched to fit entire screen
        if (tileScale <= 0) {
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            return;
        }

        int tw = image.getWidth() * tileScale;
        int th = image.getHeight() * tileScale;

        // Tegn kun de felter, der er synlige
        Rectangle clip = g.getClipBounds();
        int startX = (clip.x / tw) * tw;
        int startY = (clip.y / th) * th;
        for (int y = startY; y < clip.y + clip.height; y += th) {
            for (int x = startX; x < clip.x + clip.width; x += tw) {
                g2.drawImage(image, x, y, tw, th, null);
            }
        }
    }
}
