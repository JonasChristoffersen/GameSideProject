package Game.Crops;


import Game.GameInformation;

import java.awt.event.ActionEvent;
public class Weed extends Crops {
    private int points = 1;
    private int counter = 0;
    private String name = "Weed";




    @Override
    public void actionPerformed(ActionEvent e) {
        GameInformation.setPoints(points);
    }
}
