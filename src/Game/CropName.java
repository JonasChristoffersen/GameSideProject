package Game;

import Crops.Crop;

import java.util.ArrayList;

public enum CropName {
    WHEAT("Wheat", 2, 0),
    TOMATOS("Tomatos", 10,1),
    WEED("WEED", 2,2),
    CUCUMBER("Cucumber", 2,3);

    private final String name;
    private final int fullGrown;
    private final int index;
    private int amount = 0;

    CropName(String name, int fullGrown, int index) {
        this.name = name;
        this.fullGrown = fullGrown;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getIndex() {
        return index;
    }


    public void setAmount(int amount) {
        this.amount = amount;

    }


    public static ArrayList<Crop> makeCrops() {
        ArrayList<Crop> crops = new ArrayList<>();
        for(CropName c : CropName.values()) {
            crops.add(new Crop (c.name, null, c.fullGrown));
        }
        return crops;


    }




}
