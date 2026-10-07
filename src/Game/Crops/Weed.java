package Game.Crops;


import Game.GameInformation;

import java.awt.event.ActionEvent;
public class Weed extends Crops {
    private int points = 1;
    private int counter = 0;
    private String name = "Weed";


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }
}
