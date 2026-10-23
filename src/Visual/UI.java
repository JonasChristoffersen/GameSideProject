package Visual;

import Crops.Crop;
import Game.GameInformation;
import Game.Plot;
import Saves.SaveManager;
import Upgrades.Upgrade;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class UI {
    private JLabel moneyPerSecondAmount;
    private JLabel moneyLabelAmount;
    private GameInformation gameInformation;
    private SaveManager saveManager;
    private String imgPath;
    private ArrayList<UpgradeButtons> upgradeButtons;
    private ArrayList<PlotButton> cropButtons;
    private ArrayList<JButton> cropAmount;

    public UI(GameInformation gameInformation, SaveManager saveManager) {
        this.gameInformation = gameInformation;
        this.saveManager = saveManager;
        this.upgradeButtons = new ArrayList<>();
        this.cropButtons = new ArrayList<>();
        this.cropAmount = new ArrayList<>();
        for(Crop p : gameInformation.getCrops()) {
            cropAmount.add(new JButton());
        }

    }

    public void makeUI() {
        //TODO: Can we move the creation of panel out to other places???
        createUpgradeButtons();
        createPlotButtons();
        Window mainWindow = new Window(gameInformation.getNameOfGame());

        JScrollPane scrollUpgradePane = createUpgradeScrollPane();
        JScrollPane scrollCropAmountPane = createCropAmountScrollPane();
        Panels centerPanel = createCenterPanel();
        Panels topPanel = createTopPanel();
        Panels bottomPanel = createBottomPanel();

        //Add elements to mainWindow
        mainWindow.add(scrollUpgradePane, BorderLayout.EAST);
        mainWindow.add(scrollCropAmountPane, BorderLayout.WEST);
        mainWindow.add(centerPanel, BorderLayout.CENTER);
        mainWindow.add(topPanel, BorderLayout.NORTH);
        mainWindow.add(bottomPanel, BorderLayout.SOUTH);

        //Fixed GUI not loading correctly
        refreshAllTimer();
        mainWindow.setWindowVisible();
    }

    public Panels makeMoneyPerSecondPanel() {
        Panels moneyPerSecondPanel = new Panels(150,40);
        moneyPerSecondPanel.setBackground(new Color(211, 211, 211));

        JLabel moneyPerSecondLabel= new JLabel();
        moneyPerSecondLabel.setText("Money pr Second");
        moneyPerSecondLabel.setBounds(10, 0, 100, 30);
        moneyPerSecondPanel.add(moneyPerSecondLabel);

        moneyPerSecondAmount = new JLabel();
        moneyPerSecondAmount.setBounds(10, 20, 100, 30);
        moneyPerSecondPanel.add(moneyPerSecondAmount);
        moneyPerSecondAmount.setText(String.valueOf(gameInformation.getPointsPerSecond()));

        moneyPerSecondPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return moneyPerSecondPanel;
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

        moneyLabelAmount = new JLabel();
        moneyLabelAmount.setBounds(10, 20, 100, 30);
        moneyDisplayPanel.add(moneyLabelAmount);

        moneyDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        return moneyDisplayPanel;
    }


    public Panels createTopPanel() {
        Panels topPanel = new Panels(600, 50);
        topPanel.setBackground(Color.lightGray);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //Save game button
        Buttons saveButton = new SaveButton(gameInformation, saveManager);
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

        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for (PlotButton button : cropButtons) {
            centerPanel.add(button);
        }
        return centerPanel;
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
        for(Plot p : gameInformation.getPlots()) {
            cropButtons.add(new PlotButton(p, gameInformation));
        }
    }

    public Panels makeUpgradeSidePanel() {
        int height = upgradeButtons.size() * 115 + 30; // 100 button + 15 gap each, + 15 top/bottom
        Panels sidePanel = new Panels(200, height);
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10)); //Creates room between buttons and edges
        sidePanel.backGroundImg("Assets/StoneWallTexture.png");

        for (UpgradeButtons button : upgradeButtons) {
            button.setMaximumSize(new Dimension(180, 100));   // keeps the size fixed
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            sidePanel.add(button);
            sidePanel.add(Box.createVerticalStrut(15));
        }
        return sidePanel;
    }

    public Panels makeCropAmountSidePanel() {
        int height = cropButtons.size() * 115 + 30; // 100 button + 15 gap each, + 30/2=15 top/bottom
        Panels sidePanel = new Panels(200, height);
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10)); //Creates room between buttons and edges
        sidePanel.backGroundImg("Assets/StoneWallTexture.png");
        for(JButton b : cropAmount) {
            sidePanel.add(b);
        }
        return sidePanel;
    }

    public JScrollPane createUpgradeScrollPane() {
        JScrollPane scrollPane = new JScrollPane(makeUpgradeSidePanel());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        return scrollPane;
    }

    public JScrollPane createCropAmountScrollPane() {
        JScrollPane scrollPane = new JScrollPane(makeCropAmountSidePanel());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        JLabel test = new JLabel(String.valueOf(gameInformation.getPlots().get(0).getCrop().getAmount())); //Is this ever used?
        test.setBounds(100,100,50,50); //Is this ever used?
        test.setVisible(true); //Is this ever used?
        scrollPane.add(test); //Is this ever used?
        return scrollPane;
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
                moneyPerSecondAmount.setText(String.valueOf(gameInformation.getPointsPerSecond()));
                moneyLabelAmount.setText(df.format( gameInformation.getPoints()));
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
}