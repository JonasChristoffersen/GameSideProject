package Visual;

import Crops.Crop;
import Game.GameInformation;
import Game.Plot;
import Saves.SaveManager;
import Upgrades.Upgrade;
import Visual.Clickables.*;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;


public class UI {
    private JLabel moneyPerSecondAmount;
    private JLabel moneyLabelAmount;
    private GameInformation gameInformation;
    private SaveManager saveManager;
    private ArrayList<UpgradeButtons> upgradeButtons;
    private centerPanels centerPanels;
    //private ArrayList<PlotButton> cropButtons;
    private ArrayList<JButton> cropAmount;

    public UI(GameInformation gameInformation, SaveManager saveManager) {
        this.gameInformation = gameInformation;
        this.saveManager = saveManager;
        this.upgradeButtons = new ArrayList<>();
        this.centerPanels = new centerPanels(gameInformation);
        this.cropAmount = new ArrayList<>();
        for(Crop p : gameInformation.getCrops()) {
            Buttons button = new Buttons();
            button.backGroundImg("Assets/SmallStoneButton.png");
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setForeground(Color.WHITE);
            cropAmount.add(button);
        }
    }

    public void makeUI() {
        //TODO: Can we move the creation of panel out to other places???
        userStartGameChoice(); //Option pane that asks if they want to load data from earlier session or new game!
        createUpgradeButtons();
        createPlotButtons();
        centerPanels.buildScreens();
        Window mainWindow = new Window(gameInformation.getNameOfGame());

        JScrollPane scrollUpgradePane = createUpgradeScrollPane();
        JScrollPane scrollCropAmountPane = createCropAmountScrollPane();
        centerPanels centerPanel = centerPanels;
        Panels topPanel = createTopPanel();
        Panels bottomPanel = createBottomPanel();

        //Add elements to mainWindow
        mainWindow.add(scrollUpgradePane, BorderLayout.EAST);
        mainWindow.add(scrollCropAmountPane, BorderLayout.WEST);
        mainWindow.add(centerPanel, BorderLayout.CENTER);
        mainWindow.add(topPanel, BorderLayout.NORTH);
        mainWindow.add(bottomPanel, BorderLayout.SOUTH);

        refreshAllTimer();
        mainWindow.setWindowVisible();

    }

/*    public Panels makeMoneyPerSecondPanel() {
        Panels moneyPerSecondPanel = new Panels(150, 40);
        moneyPerSecondPanel.setBackground(new Color(211, 211, 211));

        JLabel moneyPerSecondLabel = new JLabel();
        moneyPerSecondLabel.setText("Money pr Second");
        moneyPerSecondLabel.setBounds(10, 0, 100, 30);
        moneyPerSecondPanel.add(moneyPerSecondLabel);

        moneyPerSecondAmount = new JLabel();
        moneyPerSecondAmount.setBounds(10, 20, 100, 30);
        moneyPerSecondPanel.add(moneyPerSecondAmount);
        moneyPerSecondAmount.setText(String.valueOf(gameInformation.getPointsPerSecond()));

        moneyPerSecondPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return moneyPerSecondPanel;
    }*/

    public Panels makeLevelPanel() {
        Panels levelDisplayPanel = new Panels(150, 40);
        levelDisplayPanel.backGroundImg("Assets/WoodButtonTexture.png");

        JLabel levelLabelText = new JLabel();
        levelLabelText.setText("Level");
        levelLabelText.setBounds(10, 0, 100, 30);
        levelLabelText.setForeground(Color.WHITE);
        levelDisplayPanel.add(levelLabelText);

        JLabel levelLabelAmount = new JLabel();
        levelLabelAmount.setText(String.valueOf(gameInformation.getLevel())); //Fix this to display real time amount when level logic is implemented!
        levelLabelAmount.setBounds(10, 20, 100, 30);
        levelLabelAmount.setForeground(Color.WHITE);
        levelDisplayPanel.add(levelLabelAmount);

        levelDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return levelDisplayPanel;
    }


    public Panels makeMoneyPanel() {
        Panels moneyDisplayPanel = new Panels(150, 40);
        moneyDisplayPanel.backGroundImg("Assets/WoodButtonTexture.png");

        JLabel moneyLabelText = new JLabel();
        moneyLabelText.setText("Money");
        moneyLabelText.setBounds(10, 0, 100, 30);
        moneyLabelText.setForeground(Color.WHITE);
        moneyDisplayPanel.add(moneyLabelText);

        moneyLabelAmount = new JLabel();
        moneyLabelAmount.setBounds(10, 20, 100, 30);
        moneyLabelAmount.setForeground(Color.WHITE);
        moneyDisplayPanel.add(moneyLabelAmount);

        return moneyDisplayPanel;
    }

    //TODO: Refactor this to own class
    public Panels createTopPanel() {
        Panels topPanel = new Panels(600, 50);
        topPanel.backGroundImg("Assets/WoodPanel.png");

        //Save game button
        Buttons saveButton = new SaveButton(gameInformation, saveManager);
        saveButton.backGroundImg("Assets/WoodButtonTexture.png");
        saveButton.setForeground(Color.WHITE);
        saveButton.setText("Save Game");
        saveButton.setBorder(BorderFactory.createEmptyBorder());

        //Option button
        Buttons optionButton = new OptionButton();
        optionButton.backGroundImg("Assets/WoodButtonTexture.png");
        optionButton.setForeground(Color.WHITE);
        optionButton.setText("Options/help");
        optionButton.setBorder(BorderFactory.createEmptyBorder());

        topPanel.add(saveButton);
        topPanel.add(optionButton);

        return topPanel;
    }

    //TODO: REMEMBER TO DISPLAY CROP PER SECOND ANOTHER PLACE!
    //bottomPanel.add(makeMoneyPerSecondPanel(), Box.CENTER_ALIGNMENT);
    public Panels createBottomPanel() {
        Panels bottomPanel = new Panels(300, 50);

        Buttons sellButton = new SellButton(centerPanels);
        sellButton.backGroundImg("Assets/WoodButtonTexture.png");
        sellButton.setForeground(Color.WHITE);
        sellButton.setBorder(BorderFactory.createLineBorder(Color.black));

        bottomPanel.add(makeMoneyPanel(), Box.LEFT_ALIGNMENT);
        bottomPanel.add(sellButton, Box.CENTER_ALIGNMENT);
        bottomPanel.add(makeLevelPanel(), Box.RIGHT_ALIGNMENT);

        bottomPanel.backGroundImg("Assets/WoodPanel.png");

        return bottomPanel;
    }

    public void createUpgradeButtons() {
        for(Plot p : gameInformation.getPlots()) {
            for (Upgrade upgrade : p.getUpgrades()) {
                String text = upgrade.getName() + " : " + p.getCrop().getName();
                upgradeButtons.add(new UpgradeButtons(text, upgrade, gameInformation));
            }
        }
    }

    public void createPlotButtons() {
        for(int i = 0; i < gameInformation.getPlots().size(); i++) {
            boolean isUnlocked = i < gameInformation.getUnlockedPlotCount();
            boolean isVisible = i <= gameInformation.getUnlockedPlotCount();
            centerPanels.getCropButtons().add(new PlotButton(gameInformation.getPlots().get(i),gameInformation, isUnlocked, isVisible));
        }
    }

    public JScrollPane createUpgradeScrollPane() {
        SidePanel panel = new SidePanel();
        panel.addItems(upgradeButtons, 100);
        return panel.toScrollPane();
    }

    public JScrollPane createCropAmountScrollPane() {
        SidePanel panel = new SidePanel();
        panel.addItems(cropAmount, 40);
        return panel.toScrollPane();
    }

    public void refreshAllTimer() {
        Timer timer = new Timer();
        DecimalFormat df = new DecimalFormat("#.##");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (UpgradeButtons button : upgradeButtons) {
                    button.refresh();
                }
                if (gameInformation.getUnlockedPlotCount() < centerPanels.getCropButtons().size()) {
                    centerPanels.getCropButtons().get(gameInformation.getUnlockedPlotCount()).refresh();

                    if (centerPanels.getCropButtons().get(gameInformation.getUnlockedPlotCount() - 1).isUnlocked()) {
                        centerPanels.getCropButtons().get(gameInformation.getUnlockedPlotCount()).setVisible(true);
                    }
                }

                //Out commented due to value not being used to display MPS (money pr sec) anymore! (Sell button now owns UI place)
                //moneyPerSecondAmount.setText(String.valueOf(gameInformation.getPointsPerSecond()));
                moneyLabelAmount.setText(df.format(gameInformation.getPoints()));
                gameInformation.addPoints(gameInformation.getPointsPerSecond() / 10.0);
                for(int i = 0; i < cropAmount.size(); i++) {
                    gameInformation.getCrops().get(i).giveAmountCPS();
                    String text = gameInformation.getCrops().get(i).getName() + " " + String.valueOf(gameInformation.getCrops().get(i).getAmount());
                    cropAmount.get(i).setText(String.valueOf(text));

                }
            }
        };
        timer.schedule(task, 0, 100);
    }

    //Yes=0 NO=1 close=-1
    public void userStartGameChoice() {
        String[] responses = {"Yes!\n Start new game", "No!\n Load data from earlier session"}; //, "thank you!", "*blush*"
        String message = """
                Welcome to CropClicker A/S!
                Do you wish to start a new game, or load existing data?
                """;
        int userChoice = JOptionPane.showOptionDialog(
                null,
                message,
                "Load data or start new game?",
                JOptionPane.YES_NO_OPTION,
                PLAIN_MESSAGE,
                null,
                responses,
                responses[0]
        );
        switch (userChoice) {
            case 0 -> saveManager.newGame();
            case 1 -> saveManager.loadSave();
            default -> System.exit(0);
        }
    }
}