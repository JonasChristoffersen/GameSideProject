package Game.Visual;

import javax.swing.*;
import java.util.ArrayList;

public class Window {
    private JFrame window;

    Window(String name) {
        this.window = new JFrame(name);
        window.setLayout(null);
        window.setSize(600,600);
        window.setVisible(true);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
    }


    public void addPanel(Panels panel) {
        window.add(panel.getPanel());
    }




}
