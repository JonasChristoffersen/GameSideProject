package Game;

import Game.Saves.LoadSavedData;
import Game.Upgrades.CreateUpgrades;
import Game.Visual.UI;

public class Main {
    public static void main(String[] args) {
        LoadSavedData loadSavedData = new LoadSavedData();

        loadSavedData.loadSave();
        CreateUpgrades.setStartAmount(CreateUpgrades.getBucket()); /*
        Needs to be moved somewhere else
        Sets the price based on how many of the upgrade we currently have.*/

        UI.makeUI();
        loadSavedData.loadSave();

        CreateUpgrades.setStartAmount(CreateUpgrades.getBucket());
        System.out.println(CreateUpgrades.getBucket().getAmount());

    }
}