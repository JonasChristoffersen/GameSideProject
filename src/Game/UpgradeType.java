package Game;

import Upgrades.Upgrade;

import java.util.ArrayList;

public enum UpgradeType {
    SHOVEL("Shovel", 1),
    BUCKET("Bucket", 2),
    HOE("HOE", 3);

    private String name;
    private int cropPerSecondUpgrade;



    UpgradeType(String name, int cropPerSecondUpgrade) {
        this.name = name;
        this.cropPerSecondUpgrade = cropPerSecondUpgrade;
    }

    public static ArrayList<Upgrade> makeUpgrades() {
        ArrayList<Upgrade> upgrades = new ArrayList<>();
        for(UpgradeType ut : UpgradeType.values()) {
            Upgrade u1 = new Upgrade(ut.name, ut.cropPerSecondUpgrade);
            upgrades.add(u1);
        }
        return upgrades;
    }


}
