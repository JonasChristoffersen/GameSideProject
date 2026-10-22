package Visual;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    Window(String name) {
        this.setTitle(name);
        this.setSize(1200,600);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void setWindowVisible() {
        this.setVisible(true);
    }

}
