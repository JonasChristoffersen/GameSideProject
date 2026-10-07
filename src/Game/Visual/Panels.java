package Game.Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panels extends JPanel{

    Panels(int x, int y, int w, int h) {
        this.setLayout(null);
        this.setBounds(x, y, w, h);
    }

    public void addthings(ArrayList<Buttons> array) {
        for (Buttons l : array) {
            add(l.getButton());
        }
    }

}
