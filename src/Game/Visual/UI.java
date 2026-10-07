package Game.Visual;

import Game.Crops.Tomatos;
import Game.Crops.Weed;
import Game.GameInformation;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class UI {
    public static void makeUI() {
        Window mainWindow = new Window(GameInformation.getNameOfGame());
        Panels sideBar = new Panels(400, 0, 200, 600);
        sideBar.setBackground(Color.gray);
        Panels centerPanel = new Panels(0, 50, 401, 450); //Set w to 401 so outline will look better up against sidepanel
        centerPanel.setBackground(new Color(17, 122, 26));

        //Added white background to icons to get rid of the blue standard color
        centerPanel.add(new Buttons(100,100,100,100, Weed::new)).setBackground(Color.white);
        centerPanel.add(new Buttons(200,100,100,100, Tomatos::new)).setBackground(Color.white);

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
        Panels moneyDisplayPanel = new Panels(5,505,100, 50);
        moneyDisplayPanel.setBackground(new Color(211, 211, 211));
        JLabel moneyLabelText = new JLabel();
        moneyLabelText.setText("Money");
        moneyLabelText.setBounds(10, 0, 100, 30);
        moneyDisplayPanel.add(moneyLabelText);
        JLabel moneyLabelAmount = new JLabel();
        moneyLabelAmount.setText(String.valueOf(GameInformation.getPoints())); //Fix this to display real time amount!
        moneyLabelAmount.setBounds(10, 20, 100, 30);
        moneyDisplayPanel.add(moneyLabelAmount);

        //Click pr sec panel
        Panels clickDisplayPanel = new Panels(150,505,100, 50);
        clickDisplayPanel.setBackground(new Color(211, 211, 211));
        JLabel clickLabelText = new JLabel();
        clickLabelText.setText("Click pr sec");
        clickLabelText.setBounds(10, 0, 100, 30);
        clickDisplayPanel.add(clickLabelText);
        JLabel clickLabelAmount = new JLabel();
        clickLabelAmount.setText("No variable"); //Fix this to display real time amount!
        clickLabelAmount.setBounds(10, 20, 100, 30);
        clickDisplayPanel.add(clickLabelAmount);

        //Level panel
        Panels levelDisplayPanel = new Panels(295,505,100, 50);
        levelDisplayPanel.setBackground(new Color(211, 211, 211));
        JLabel levelLabelText = new JLabel();
        levelLabelText.setText("Level");
        levelLabelText.setBounds(10, 0, 100, 30);
        levelDisplayPanel.add(levelLabelText);
        JLabel levelLabelAmount = new JLabel();
        levelLabelAmount.setText(String.valueOf(GameInformation.getLevel())); //Fix this to display real time amount when level logic is implemented!
        levelLabelAmount.setBounds(10, 20, 100, 30);
        levelDisplayPanel.add(levelLabelAmount);

        //Outlines
        sideBar.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black));
        topBackGroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomBackGroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        moneyDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        clickDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        levelDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //Add elements to mainWindow
        mainWindow.add(sideBar);
        mainWindow.add(centerPanel);
        mainWindow.add(saveButton);
        mainWindow.add(topBackGroundPanel);
        mainWindow.add(moneyDisplayPanel);
        mainWindow.add(clickDisplayPanel);
        mainWindow.add(levelDisplayPanel);
        mainWindow.add(bottomBackGroundPanel);

        //Fixed GUI not loading correctly
        mainWindow.setWindowVisible();
    }
}