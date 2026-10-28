package Upgrades;

import Crops.Crop;

import java.util.ArrayList;

public class Cost {
    private String name;
    private int amount;


    public Cost(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " " + amount;
    }
}
