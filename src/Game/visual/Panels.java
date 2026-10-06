package Game.visual;

import javax.swing.*;
import java.util.ArrayList;

public class Panels {
    private JPanel panel;
    private ArrayList<Buttons> buttons;

    Panels() {
        this.panel = new JPanel(null);
        panel.setLayout(null);
    }


    public JPanel getPanel() {
        return panel;
    }
}
