package Game;

import Game.Saves.LoadSavedData;
import Game.Visual.UI;

public class Main {
    public static void main(String[] args) {
        LoadSavedData loadSavedData = new LoadSavedData();

        loadSavedData.loadSave();
        UI.makeUI();
    }
}