package Game.visual;

import javax.swing.*;

public class Buttons {
    private JButton button;

    Buttons(String text) {
        this.button = new JButton(text);

    }

    public void setButton(int x, int y, int w, int h) {
        this.button.setBounds(x,y,w,h);
    }

    public JButton getButton() {
        return button;
    }
}
