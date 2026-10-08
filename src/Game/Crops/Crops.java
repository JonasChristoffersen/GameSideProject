package Game.Crops;

import Game.GameInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleToIntFunction;
import java.util.function.Supplier;


public abstract class Crops implements ActionListener {
    private String name;
    private int points;
    private int counter;
    private ImageIcon image;

    Crops(String name, int points, ImageIcon image) {
        this.name = name;
        this.points = points;
        this.image = image;
    }

    public void actionPerformed(Crops type){
        GameInformation.addPoints(type.getPoints());
        System.out.println(GameInformation.getPoints());
    }

    public void actionPerformed(ActionEvent e) {

    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }
}
