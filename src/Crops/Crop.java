package Crops;
import javax.swing.*;


public class Crop {
    private final String name;
    private final int points;
    private int counter;
    private final ImageIcon image;
    private int fullGrown;
    private int amount;

    public Crop(String name, int points, ImageIcon image, int fullGrown) {
        this.name = name;
        this.points = points;
        this.image = image;
        this.fullGrown = fullGrown;
        this.amount = 0;
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


    public int getFullGrown() {
        return fullGrown;
    }

    public void addAmount(int amount) {
        this.amount+=amount;
    }

    public int getAmount() {
        return amount;
    }

}
