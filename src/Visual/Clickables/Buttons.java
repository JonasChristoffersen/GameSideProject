package Visual.Clickables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Buttons extends JButton{
    private BufferedImage image;
    private int tileScale = 0;

    public void backGroundImg(String imgPath) {
        this.image = loadImage(imgPath);
        setContentAreaFilled(false);
        setOpaque(false);
        this.tileScale = 0;
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
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
        super.paintComponent(g);  // tegner teksten ovenpå billedet
    }
}