package Game.Saves;

import java.io.FileWriter;
import java.io.IOException;

import Game.GameInformation;

public class SaveGame {
    //Easy to scall up for storing more data!
    public static void userSaveAction() {
        try {
            FileWriter writer = new FileWriter(GameInformation.getSavedDataPath());
            writer.write("Points, Level, UpgradeAmountShovel"); //ClickPrSec,
            writer.write("\n" + GameInformation.getPoints() + ", " + GameInformation.getLevel() + ", " +  Game.Upgrades.Upgrades.getAmount());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}