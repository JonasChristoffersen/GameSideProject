package Game;

import Crops.Crop;
import Upgrades.Upgrade;

import java.util.ArrayList;

public class Plot {
    private Crop crop;
    private ArrayList<Upgrade> upgrades;
    private int cost;
    private int id;
    private static int count = 0;

    public Plot(Crop crop) {
        this.crop = crop;
        this.upgrades = new ArrayList<>();
        this.upgrades = UpgradeType.makeUpgrades();
        this.id = count;
        count++;
        this.cost = id * 10;
    }

    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }

    public Crop getCrop() {
        return crop;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}
