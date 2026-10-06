package Game.visual;

import Game.GameInformation;

import javax.swing.*;
import java.util.ArrayList;

public class Window {
    private JFrame window;
    private ArrayList<Panels> panels;

    Window(String name) {
        this.window = new JFrame(name);
        this.panels = new ArrayList<Panels>();
        window.setLayout(null);
    }


    public void addPanel(Panels panel) {
        this.panels.add(panel);
        window.add(panel.getPanel());
    }




}
