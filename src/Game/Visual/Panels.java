package Game.Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panels {
    private JPanel panel;

    Panels(int x, int y, int w, int h) {
        this.panel = new JPanel(null);
        panel.setLayout(null);
        panel.setBounds(x, y, w, h);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addthings(ArrayList<Buttons> array) {
        for (Buttons l : array) {
            panel.add(l.getButton());
        }
    }

}
