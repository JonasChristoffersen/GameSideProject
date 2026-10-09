package Game.Saves;

import java.io.FileWriter;
import java.io.IOException;

import Game.GameInformation;
import Game.Upgrades.CreateUpgrades;
import Game.Upgrades.Shovel;
import Game.Upgrades.Upgrades;
import Game.Visual.UI;

public class SaveGame {
    //Easy to scall up for storing more data!
    public void userSaveAction() {
        try {
            FileWriter writer = new FileWriter(GameInformation.getSavedDataPath());
            writer.write("Points, Level, MoneyPerSecond, ShovelAmount, BucketAmount");
            writer.write("\n" + GameInformation.getPoints()
                    + ", " + GameInformation.getLevel()
                    + ", " + GameInformation.getPointsPerSecond()
                    + ", " + CreateUpgrades.getShovel().getAmount()
                    + ", " + CreateUpgrades.getBucket().getAmount()
            );
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}