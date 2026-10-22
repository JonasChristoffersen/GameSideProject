package Visual;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panels extends JPanel{
    private String imgPath;

    Panels(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));

    }

    public void backGroundImg(String imgPath) {
        this.imgPath = imgPath;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imgPath != null) {
            try {
                BufferedImage image = ImageIO.read(new File(imgPath));
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
