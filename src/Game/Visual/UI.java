package Game.Visual;

import Game.Crops.Tomatos;
import Game.Crops.Weed;
import Game.GameInformation;
import Game.Upgrades.CreateUpgrades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.JarEntry;

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
        mainWindow.add(moneyDisplayPanel);
        mainWindow.add(moneyPerSecondPanel);
        mainWindow.add(levelDisplayPanel);
        mainWindow.add(bottomBackGroundPanel);
        mainWindow.add(centerPanel);
        mainWindow.add(topBackGroundPanel);

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
        moneyPerSecondAmount.setText(String.valueOf(GameInformation.getPointsPerSecond()));
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
        Panels topBackGroundPanel = new Panels(0,0,600,61) {
            @Override
            protected void paintComponent(Graphics g) {
                BufferedImage skyPNG = null;
                try {
                    skyPNG = ImageIO.read(new File("src/Game/Assets/SkyTexture.png"));
                    super.paintComponent(g);
                    g.drawImage(skyPNG, 0, 0, 400, 100, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        //Save game button
        Buttons saveButton = new Buttons(5, 5 ,90, 40);
        saveButton.setBackground(Color.gray);
        saveButton.setText("Save Game");
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black));

        topBackGroundPanel.add(saveButton);

        return topBackGroundPanel;
    }

    public static Panels makeBottomBackGroundPanel() {
        Panels bottomBackGroundPanel = new Panels(0, 500, 400, 62) {
            @Override
            protected void paintComponent(Graphics g) {
                BufferedImage fencePNG = null;
                BufferedImage grassPNG = null;
                try {
                    fencePNG = ImageIO.read(new File("src/Game/Assets/FenceTexureInvisBackground.png"));
                    grassPNG = ImageIO.read(new File("src/Game/Assets/GrassCenterPanel.png"));
                    super.paintComponent(g);
                    g.drawImage(grassPNG, 0, 0, 1300, 1200, null);
                    g.drawImage(fencePNG, -60, -75, 200, 200, null);
                    g.drawImage(fencePNG, 22, -75, 200, 200, null);
                    g.drawImage(fencePNG, 104, -75, 200, 200, null);
                    g.drawImage(fencePNG, 186, -75, 200, 200, null);
                    g.drawImage(fencePNG, 268, -75, 200, 200, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return bottomBackGroundPanel;
    }

    public static Panels makeCenterPanel() {
        Panels centerPanel = new Panels(0, 50, 400, 600) {
            @Override
            protected void paintComponent(Graphics g) {
                BufferedImage grassPNG = null;
                try {
                    grassPNG = ImageIO.read(new File("src/Game/Assets/GrassCenterPanel.png"));
                    super.paintComponent(g);
                    g.drawImage(grassPNG, -800, -800, 1300, 1300, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        centerPanel.add(new Buttons(100,100,100,100, new Weed())).setBackground(Color.white);
        centerPanel.add(new Buttons(200,100,100,100, new Tomatos())).setBackground(Color.white);

        return centerPanel;


    }

    public static Panels makeSideBar() {
        Panels sideBar = new Panels(400, 0, 200, 600) {
            @Override
            protected void paintComponent(Graphics g) {
                BufferedImage stoneWallPNG = null;
                try {
                    stoneWallPNG = ImageIO.read(new File("src/Game/Assets/StoneWall.png"));
                    super.paintComponent(g);
                    g.drawImage(stoneWallPNG, 0, 0, 200, 200, null);
                    g.drawImage(stoneWallPNG, 0, 200, 200, 200, null);
                    g.drawImage(stoneWallPNG, 0, 400, 200, 200, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        sideBar.add(new Buttons(10, 10, 180, 90, CreateUpgrades.getShovel()));
        sideBar.add(new Buttons(10, 140, 180, 90, CreateUpgrades.getBucket()));
        sideBar.setBorder(BorderFactory.createLineBorder(Color.black));


        return sideBar;
    }

    public static void updateMoneyPerSecond() {
        moneyPerSecondAmount.setText(String.valueOf(GameInformation.getPointsPerSecond()));
    }
}