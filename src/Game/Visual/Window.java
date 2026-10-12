package Game.Visual;

import javax.swing.*;

public class Window extends JFrame {

    Window(String name) {
        this.setTitle(name);
        this.setSize(615,600);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void setWindowVisible() {
        this.setVisible(true);
    }

}
