package Game;

import Crops.Crop;
import Upgrades.Upgrades;

import java.util.ArrayList;

public class Plot {
    private Crop crop;
    private ArrayList<Upgrades> upgrades;

    public Plot(Crop crop) {
        this.crop = crop;
        this.upgrades = new ArrayList<>();
        createUpgrades();
    }

    public void createUpgrades(){
        upgrades.add(new Upgrades("Shovel", 1, 20));
        upgrades.add(new Upgrades("Bucket", 2, 30));
        upgrades.add(new Upgrades("Hoe", 3, 50));
    }


    public ArrayList<Upgrades> getUpgrades() {
        return upgrades;
    }

    public Crop getCrop() {
        return crop;
    }
}
