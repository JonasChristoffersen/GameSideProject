package Game.Crops;

import Game.GameInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleToIntFunction;
import java.util.function.Supplier;


public abstract class Crops implements ActionListener {
    private String name;
    private int points;
    private int counter;

    public void actionPerformed(Crops type){
        System.out.println(type.getName());
        GameInformation.addPoints(type.getPoints());
        System.out.println(type.getPoints());
        System.out.println(GameInformation.getPoints());
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
