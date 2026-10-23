package Upgrades;

import Crops.Crop;

public class Upgrade {
    private String name;
    private int cropPerSecond;
    private Crop cost;
    private int amount;
    //TODO: add icon for upgrades.
    public Upgrade(String name, int cropPerSecond, int cost) {
        this.name = name;
        this.cropPerSecond = cropPerSecond;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getCropPerSecond() {
        return cropPerSecond;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }

    public void increaseCost(){
        cost *= 1.1;
    }

    public void setPrice(int amount) {
        this.cost = amount;
    }
}
