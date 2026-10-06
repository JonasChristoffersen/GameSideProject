package Game.Visual;

import javax.swing.*;

public class Buttons {
    private JButton button;

    Buttons(String text, int x, int y, int w, int h) {
        this.button = new JButton(text);
        setButton(x,y,w,h);


    }

    public void setButton(int x, int y, int w, int h) {
        this.button.setBounds(x,y,w,h);
    }

    public JButton getButton() {
        return button;
    }
}
