package Game.Visual;

import Game.Crops.Tomatos;
import Game.Crops.Weed;
import Game.GameInformation;
import Game.Upgrades.Shovel;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class UI {
    private static Timer timer = new Timer();
    private static JLabel moneyPerSecondAmount;

    public static void makeUI() {
        //TODO: Can we move the creation of panel out to other places???
        Window mainWindow = new Window(GameInformation.getNameOfGame());

        Panels sideBar = makeSideBar();
        Panels centerPanel = makeCenterPanel();
        Panels moneyDisplayPanel = makeMoneyPanel();
        Panels moneyPerSecondPanel = makeMoneyPerSecondPanel();
        Panels levelDisplayPanel = makeLevelPanel();
        Panels topBackGroundPanel = makeTopBackgroundPanel();
        Panels bottomBackGroundPanel = makeBottomBackGroundPanel();



        //Add elements to mainWindow
        mainWindow.add(sideBar);
        mainWindow.add(centerPanel);
        mainWindow.add(topBackGroundPanel);
        mainWindow.add(moneyDisplayPanel);
        mainWindow.add(moneyPerSecondPanel);
        mainWindow.add(levelDisplayPanel);
        mainWindow.add(bottomBackGroundPanel);

        //Fixed GUI not loading correctly
        mainWindow.setWindowVisible();
    }

    public static Panels makeBottomBackgroundPanel() {
        Panels bottomBackGroundPanel = new Panels(0,499,600,62);
        bottomBackGroundPanel.setBackground(Color.lightGray);

        return bottomBackGroundPanel;
    }

    public static Panels makeMoneyPerSecondPanel() {
        Panels moneyPerSecond = new Panels(150,505,100, 50);
        moneyPerSecond.setBackground(new Color(211, 211, 211));
        JLabel moneyPerSecondLabel= new JLabel();
        moneyPerSecondLabel.setText("Money pr Second");
        moneyPerSecondLabel.setBounds(10, 0, 100, 30);
        moneyPerSecond.add(moneyPerSecondLabel);
        moneyPerSecondAmount = new JLabel();
        moneyPerSecondAmount.setBounds(10, 20, 100, 30);
        moneyPerSecond.add(moneyPerSecondAmount);
        TimerTask updateMoney= new TimerTask() {
            @Override
            public void run() {
                GameInformation.addPoints(GameInformation.getPointsPerSecond());
            }
        };

        moneyPerSecond.setBorder(BorderFactory.createLineBorder(Color.black));
        timer.schedule(updateMoney, 0, 1000);

        return moneyPerSecond;
    }

    public static Panels makeLevelPanel() {
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
        levelDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return levelDisplayPanel;
    }


    public static Panels makeMoneyPanel() {
        Panels moneyDisplayPanel = new Panels(5,505,100, 50);
        moneyDisplayPanel.setBackground(new Color(211, 211, 211));
        JLabel moneyLabelText = new JLabel();
        moneyLabelText.setText("Money");
        moneyLabelText.setBounds(10, 0, 100, 30);
        moneyDisplayPanel.add(moneyLabelText);
        JLabel moneyLabelAmount = new JLabel();
        moneyLabelAmount.setBounds(10, 20, 100, 30);
        moneyDisplayPanel.add(moneyLabelAmount);
        moneyDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        TimerTask displayMoney = new TimerTask() {
            @Override
            public void run() {
                moneyLabelAmount.setText(String.valueOf(GameInformation.getPoints()));
            }
        };
        timer.schedule(displayMoney,0,10);

        return moneyDisplayPanel;
    }


    public static Panels makeTopBackgroundPanel() {
        Panels topBackGroundPanel = new Panels(0,0,600,61);
        topBackGroundPanel.setBackground(Color.lightGray);
        topBackGroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //Save game button
        Buttons saveButton = new Buttons(5, 5 ,90, 40);
        saveButton.setBackground(Color.gray);
        saveButton.setText("Save Game");
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black));

        topBackGroundPanel.add(saveButton);

        return topBackGroundPanel;
    }

    public static Panels makeBottomBackGroundPanel() {
        Panels bottomBackGroundPanel = new Panels(0, 499, 600, 62);
        bottomBackGroundPanel.setBackground(Color.lightGray);
        bottomBackGroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return bottomBackGroundPanel;
    }

    public static Panels makeCenterPanel() {
        Panels centerPanel = new Panels(0, 50, 401, 450); //Set w to 401 so outline will look better up against sidepanel
        centerPanel.setBackground(new Color(17, 122, 26));

        centerPanel.add(new Buttons(100,100,100,100, Weed::new)).setBackground(Color.white);
        centerPanel.add(new Buttons(200,100,100,100, Tomatos::new)).setBackground(Color.white);

        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return centerPanel;


    }

    public static Panels makeSideBar() {
        Panels sideBar = new Panels(400, 0, 200, 600);
        sideBar.setBackground(Color.gray);
        sideBar.add(new Buttons(0, 0, 200, 100, new Shovel()));
        sideBar.setBorder(BorderFactory.createLineBorder(Color.black));


        return sideBar;
    }

    public static void updateMoneyPerSecond() {
        moneyPerSecondAmount.setText(String.valueOf(GameInformation.getPointsPerSecond()));
    }
}