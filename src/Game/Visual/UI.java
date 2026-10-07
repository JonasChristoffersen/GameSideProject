package Game.Visual;

import Game.Crops.Tomatos;
import Game.Crops.Weed;
import Game.GameInformation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI {
    static ArrayList<Buttons> sideBarButtons = new ArrayList<>();
    public static void makeUI() {
            Window mainWindow = new Window(GameInformation.getNameOfGame());
            Panels sideBar = new Panels(400, 0, 200, 600);
            Panels centerPanel = new Panels(0, 50, 400, 450);
            centerPanel.setBackground(new Color(17, 122, 26));


            sideBarButtons.add(new Buttons(0,0,200,100, Weed::new));
            sideBarButtons.add(new Buttons(0,100,200,100, Tomatos::new));

            sideBar.addthings(sideBarButtons);

            mainWindow.add(sideBar);
            mainWindow.add(centerPanel);
    }
}