package Crops;
import javax.swing.*;


public class Crop {
    private final String name;
    private int counter;
    private final ImageIcon image;
    private int fullGrown;
    private int amount;
    private int cropPerSecond;

    public Crop(String name, ImageIcon image, int fullGrown) {
        this.name = name;
        this.image = image;
        this.fullGrown = fullGrown;
    }

    public void buy(int amount) {
        this.amount -= amount;
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

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void subtractAmount(int amount) {
        this.amount -= amount;
    }

    public int getCropPerSecond() {
        return cropPerSecond;
    }

    public void giveAmountCPS() {
        amount += cropPerSecond;
    }
}
