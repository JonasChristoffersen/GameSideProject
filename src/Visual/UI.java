package Visual;

import Crops.Crops;
import Game.GameInformation;
import Upgrades.Upgrades;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class UI {
    private Timer timer = new Timer();
    private JLabel moneyPerSecondAmount;
    private GameInformation gameInformation;
    private ArrayList<UpgradeButtons> upgradeButtons;
    private ArrayList<CropButtons> cropButtons;

    public UI(GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.upgradeButtons = new ArrayList<>();
        this.cropButtons = new ArrayList<>();
        createUpgradeButtons();
        createCropButtons();
    }

    public void makeUI() {
        //TODO: Can we move the creation of panel out to other places???
        Window mainWindow = new Window(gameInformation.getNameOfGame());

        JScrollPane scrollPane = createScrollPane();
        Panels centerPanel = createCenterPanel();
        Panels topPanel = createTopPanel();
        Panels bottomPanel = createBottomPanel();



        //Add elements to mainWindow
        mainWindow.add(scrollPane, BorderLayout.EAST);
        mainWindow.add(centerPanel, BorderLayout.CENTER);
        mainWindow.add(topPanel, BorderLayout.NORTH);
        mainWindow.add(bottomPanel, BorderLayout.SOUTH);

        //Fixed GUI not loading correctly
        mainWindow.setWindowVisible();
    }


    public Panels makeMoneyPerSecondPanel() {
        Panels moneyPerSecond = new Panels(150,40);
        moneyPerSecond.setBackground(new Color(211, 211, 211));
        JLabel moneyPerSecondLabel= new JLabel();
        moneyPerSecondLabel.setText("Money pr Second");
        moneyPerSecondLabel.setBounds(10, 0, 100, 30);
        moneyPerSecond.add(moneyPerSecondLabel);
        moneyPerSecondAmount = new JLabel();
        moneyPerSecondAmount.setBounds(10, 20, 100, 30);
        moneyPerSecond.add(moneyPerSecondAmount);
        moneyPerSecondAmount.setText(String.valueOf(gameInformation.getPointsPerSecond()));
        TimerTask updateMoney= new TimerTask() {
            @Override
            public void run() {
                gameInformation.addPoints(gameInformation.getPointsPerSecond());
            }
        };

        moneyPerSecond.setBorder(BorderFactory.createLineBorder(Color.black));
        timer.schedule(updateMoney, 0, 1000);

        return moneyPerSecond;
    }

    public Panels makeLevelPanel() {
        Panels levelDisplayPanel = new Panels(150, 40);
        levelDisplayPanel.setBackground(new Color(211, 211, 211));
        JLabel levelLabelText = new JLabel();
        levelLabelText.setText("Level");
        levelLabelText.setBounds(10, 0, 100, 30);
        levelDisplayPanel.add(levelLabelText);
        JLabel levelLabelAmount = new JLabel();
        levelLabelAmount.setText(String.valueOf(gameInformation.getLevel())); //Fix this to display real time amount when level logic is implemented!
        levelLabelAmount.setBounds(10, 20, 100, 30);
        levelDisplayPanel.add(levelLabelAmount);
        levelDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return levelDisplayPanel;
    }


    public Panels makeMoneyPanel() {
        Panels moneyDisplayPanel = new Panels(150, 40);
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
                moneyLabelAmount.setText(String.valueOf(gameInformation.getPoints()));
            }
        };
        timer.schedule(displayMoney,0,10);

        return moneyDisplayPanel;
    }


    public Panels createTopPanel() {
        Panels topPanel = new Panels(600, 50);
        topPanel.setBackground(Color.lightGray);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //Save game button
        Buttons saveButton = new Buttons(5, 5 ,90, 40, gameInformation);
        saveButton.setBackground(Color.gray);
        saveButton.setText("Save Game");
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black));

        topPanel.add(saveButton);

        return topPanel;
    }

    public Panels createBottomPanel() {
        Panels bottomPanel = new Panels(600, 50);
        BoxLayout boxLayout = new BoxLayout(bottomPanel, BoxLayout.X_AXIS);
        bottomPanel.setLayout(boxLayout);

        bottomPanel.add(makeMoneyPanel(), Box.LEFT_ALIGNMENT);
        bottomPanel.add(makeMoneyPerSecondPanel(), Box.CENTER_ALIGNMENT);
        bottomPanel.add(makeLevelPanel(), Box.RIGHT_ALIGNMENT);

        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return bottomPanel;
    }

    public Panels createCenterPanel() {
        Panels centerPanel = new Panels(200, 200); //Set w to 401 so outline will look better up against sidepanel
        centerPanel.setBackground(new Color(17, 122, 26));

        //centerPanel.add(new Buttons(100,100,100,100, new Weed())).setBackground(Color.white);
        //centerPanel.add(new Buttons(200,100,100,100, new Tomatos())).setBackground(Color.white);

        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return centerPanel;

    }

    public void createUpgradeButtons() {
        for (Upgrades upgrade : gameInformation.getUpgrades()) {
            upgradeButtons.add(new UpgradeButtons(upgrade, gameInformation));
        }
    }

    public void createCropButtons() {
        for (Crops crop : gameInformation.getCrops()) {
            cropButtons.add(new CropButtons(crop, gameInformation));
        }
    }

    public Panels makeSidePanel() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING, 0, 0);
        int height = upgradeButtons.size() * 100;
        Panels sidePanel = new Panels(200, height);
        sidePanel.setLayout(flowLayout);

        sidePanel.setBackground(Color.gray);
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for (UpgradeButtons button : upgradeButtons) {
            sidePanel.add(button);
        }

        return sidePanel;
    }

    public JScrollPane createScrollPane() {
        JScrollPane scrollPane = new JScrollPane(makeSidePanel());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        return scrollPane;
    }

    public void updateMoneyPerSecond() {
        moneyPerSecondAmount.setText(String.valueOf(gameInformation.getPointsPerSecond()));
    }
}