package Game;

import Saves.SaveManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameInformation gameInformation = new GameInformation();
        Saves.SaveManager saveManager = new Saves.SaveManager(gameInformation);
        Visual.UI ui = new Visual.UI(gameInformation, saveManager);

        saveManager.loadSave();
        ui.makeUI();
    }
}