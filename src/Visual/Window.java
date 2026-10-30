package Visual;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Window extends JFrame {

    Window(String name) {
        this.setTitle(name);
        this.setSize(1200,600);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //sets icon of app
        try {
            Image img = ImageIO.read(new File("Assets/AppIcon.png"));
            setIconImage(img);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setWindowVisible() {
        this.setVisible(true);
    }

}
