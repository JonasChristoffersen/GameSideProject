package Game.visual;

import javax.swing.*;
import java.util.ArrayList;

public class Panels {
    private JPanel panel;
    private ArrayList<Buttons> buttons;

    Panels(int x, int y, int w, int h) {
        this.panel = new JPanel(null);
        panel.setLayout(null);
        panel.setBounds(x, y, w, h);
    }

    public ArrayList<Buttons> getButtons() {
        return buttons;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addButon(Buttons button) {
        this.buttons.add(button);
        panel.add(button.getButton());
    }
}
