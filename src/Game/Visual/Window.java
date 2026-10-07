package Game.Visual;

import javax.swing.*;
import java.util.ArrayList;

public class Window extends JFrame {

    Window(String name) {
        this.setTitle(name);
        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }


}
