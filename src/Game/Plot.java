package Game;

import Crops.Crop;
import Upgrades.Upgrade;

import java.util.ArrayList;

public class Plot {
    private Crop crop;
    private ArrayList<Upgrade> upgrades;

    public Plot(Crop crop) {
        this.crop = crop;
        this.upgrades = new ArrayList<>();
        createUpgrades();
    }

    public void createUpgrades(){
        upgrades.add(new Upgrade("Shovel", 1, 20));
        upgrades.add(new Upgrade("Bucket", 2, 30));
        upgrades.add(new Upgrade("Hoe", 3, 50));
    }


    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }

    public Crop getCrop() {
        return crop;
    }
}
