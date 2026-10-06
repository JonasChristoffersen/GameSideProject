package Game.Crops;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public abstract class Crops implements ActionListener {
    private String name;
    private int points;
    private int counter;

    public abstract void actionPerformed(ActionEvent e);




}
