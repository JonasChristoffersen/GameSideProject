package Upgrades;

import Crops.Crop;
import Game.CropName;

import java.util.ArrayList;

public class Upgrade {
    private String name;
    private int cropPerSecond;
    private int cost;
    private int amount;
    private ArrayList<Cost> costs;
    //TODO: add icon for upgrades.
    public Upgrade(String name, int cropPerSecond) {
        this.name = name;
        this.cropPerSecond = cropPerSecond;
        this.cost = cost;
        this.costs = CropName.makeCost();
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

    public void addCost(Cost costs) {
        this.costs.add(costs);

    }


    public ArrayList<Cost> getCosts() {
        return costs;
    }
}
