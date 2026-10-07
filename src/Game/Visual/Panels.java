package Game.Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panels extends JPanel{
    private JPanel panel;

    Panels(int x, int y, int w, int h) {
        this.panel = new JPanel(null);
        panel.setLayout(null);
        panel.setBounds(x, y, w, h);
        panel.setBackground(new Color(17, 122, 26));

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
