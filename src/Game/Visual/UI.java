package Game.Visual;

import Game.Crops.Tomatos;
import Game.Crops.Weed;
import Game.GameInformation;

import javax.swing.*;
import java.awt.*;

public class UI {
    public static void makeUI() {
        Window mainWindow = new Window(GameInformation.getNameOfGame());
        Panels sideBar = new Panels(400, 0, 200, 600);
        sideBar.setBackground(Color.gray);
        Panels centerPanel = new Panels(-1, 50, 409, 450);
        centerPanel.setBackground(new Color(17, 122, 26));

        centerPanel.add(new Buttons(100,100,100,100, Weed::new));
        centerPanel.add(new Buttons(200,100,100,100, Tomatos::new));

        //Save game button
        Buttons saveButton = new Buttons(-1, 0 ,101, 51);
        saveButton.setBackground(Color.lightGray);
        saveButton.setText("Save Game");

        //Outlines
        sideBar.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black));

        mainWindow.add(sideBar);
        mainWindow.add(centerPanel);
        mainWindow.add(saveButton);
    }
}