package Game.Visual;

import Game.Crops.Tomatos;
import Game.Crops.Weed;
import Game.GameInformation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI {
    static ArrayList<Buttons> sideBarButtons = new ArrayList<>();
    static ArrayList<Buttons> farmingPlotButtons = new ArrayList<>();
    public static void makeUI() {
        Window mainWindow = new Window(GameInformation.getNameOfGame());
        Panels sideBar = new Panels(400, 0, 200, 600);
        sideBar.setBackground(Color.gray);
        Panels centerPanel = new Panels(0, 50, 400, 450);
        centerPanel.setBackground(new Color(17, 122, 26));


        farmingPlotButtons.add(new Buttons(100,100,100,100, Weed::new));
        farmingPlotButtons.add(new Buttons(200,100,100,100, Tomatos::new));

        //sideBar.addthings(sideBarButtons);
        centerPanel.addthings(farmingPlotButtons);

        //Save game button
        Buttons saveButton = new Buttons(0, 0 ,100, 50);
        saveButton.setBackground(Color.lightGray);
        saveButton.setText("Save Game");

        //Outlines
        Panels outlineTop = new Panels(0,50,400,2);
        outlineTop.setBackground(Color.black);
        Panels outlineRight = new Panels(400,0,2,600);
        outlineRight.setBackground(Color.black);
        Panels outlineBottom = new Panels(0,500,400,2);
        outlineBottom.setBackground(Color.black);

        mainWindow.add(outlineTop);
        mainWindow.add(outlineRight);
        mainWindow.add(outlineBottom);

        mainWindow.add(sideBar);
        mainWindow.add(centerPanel);
        mainWindow.add(saveButton);
    }
}