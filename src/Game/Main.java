package Game;

import Saves.SaveManager;

public class Main {
    public static void main(String[] args) {
        GameInformation gameInformation = new GameInformation();
        Saves.SaveManager saveManager = new Saves.SaveManager();
        Visual.UI ui = new Visual.UI(gameInformation);

        saveManager.loadSave(gameInformation);
        ui.makeUI();
    }
}