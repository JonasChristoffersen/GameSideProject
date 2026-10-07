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
        Panels centerPanel = new Panels(0, 50, 401, 450); //Set w to 401 so outline will look better up against sidepanel
        centerPanel.setBackground(new Color(17, 122, 26));

        centerPanel.add(new Buttons(100,100,100,100, Weed::new));
        centerPanel.add(new Buttons(200,100,100,100, Tomatos::new));

        //Top background panel
        Panels topBackGroundPanel = new Panels(0,0,600,61);
        topBackGroundPanel.setBackground(Color.lightGray);

        //Bottom background panel
        Panels bottomBackGroundPanel = new Panels(0,499,600,62);
        bottomBackGroundPanel.setBackground(Color.lightGray);

        //Save game button
        Buttons saveButton = new Buttons(5, 5 ,90, 40);
        saveButton.setBackground(Color.gray);
        saveButton.setText("Save Game");

        //Money panel
        Panels moneyDisplayPanel = new Panels(5,505,150, 50);
        JLabel moneyLabel = new JLabel();
        moneyLabel.setText("THIS TEXT IS NOT DISPLAYED!");
        moneyDisplayPanel.add(moneyLabel);
        moneyDisplayPanel.setBackground(Color.gray);


        //Outlines
        sideBar.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black));
        topBackGroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomBackGroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        moneyDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //Add elements to mainWindow
        mainWindow.add(sideBar);
        mainWindow.add(centerPanel);
        mainWindow.add(saveButton);
        mainWindow.add(topBackGroundPanel);
        mainWindow.add(moneyDisplayPanel);
        mainWindow.add(bottomBackGroundPanel);

        //Fixed GUI not loading currectly:
        mainWindow.setWindowVisible();
    }
}