package Game;

import Crops.Crop;
import Upgrades.Cost;
import Upgrades.Upgrade;

import java.util.ArrayList;

public class Plot {
    private Crop crop;
    private ArrayList<Upgrade> upgrades;

    public Plot(Crop crop) {
        this.crop = crop;
        this.upgrades = new ArrayList<>();
        this.upgrades = UpgradeType.makeUpgrades();
    }


    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }

    public Crop getCrop() {
        return crop;
    }
}
