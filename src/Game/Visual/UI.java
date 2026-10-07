package Game.Visual;

import Game.Crops.Weed;
import Game.GameInformation;

public class UI {
    public static void makeUI() {
            Window mainWindow = new Window(GameInformation.getNameOfGame());
            Panels sideBar = new Panels(400, 0, 200, 600);
            Buttons button = new Buttons("Hvede", 0, 0, 200, 100, Weed::new);
            sideBar.addButon(button);
            mainWindow.addPanel(sideBar);
    }

}