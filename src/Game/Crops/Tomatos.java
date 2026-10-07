package Game.Crops;

import java.awt.event.ActionEvent;

public class Tomatos extends Crops{
    private String name = "Tomatoes";
    private int counter = 0;
    private int points = 2;


    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
