package Visual;

import Game.GameInformation;
import Visual.Clickables.Buttons;
import Visual.Clickables.PlotButton;
import Visual.Clickables.SellCropButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class centerPanels extends JPanel {
    private ArrayList<PlotButton> cropButtons;
    private CardLayout cardLayout;
    private GameInformation gameInformation;

    private final Dimension cropNameBoxSize = new Dimension(145, 25);
    private final Dimension cropSellBoxSize = new Dimension(120, 25);

    public static final String plotScreen = "plotScreen";
    public static final String sellScreen = "sellScreen";

    public centerPanels(GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.cropButtons = new ArrayList<>();
        this.cardLayout = new CardLayout();
        setLayout(cardLayout);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void buildScreens() {
        add(centerPlotPanel(), plotScreen);
        add(centerSellPanel(), sellScreen);
    }

    public void showScreen(String name) {
        cardLayout.show(this, name);
    }

    public ArrayList<PlotButton> getCropButtons() {
        return cropButtons;
    }

    public Panels centerPlotPanel() {
        Panels centerPlotPanel = new Panels(200, 200); //Set w to 401 so outline will look better up against sidepanel
        centerPlotPanel.backGroundImg("Assets/GrassBackground.png");
        for (PlotButton button : cropButtons) {
            centerPlotPanel.add(button);
        }
        //centerPlotPanel.setOpaque(true);
        return centerPlotPanel;
    }

    //Still missing actual sell screen
    public Panels centerSellPanel() {
        Panels sellPanel = new Panels(200, 200);
        sellPanel.setLayout(new BoxLayout(sellPanel, BoxLayout.Y_AXIS));
        sellPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sellPanel.backGroundImg("Assets/SkyBackgroundNoSun.png");

        Panels sellHeaderPanel = new Panels(600,30);
        sellHeaderPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        sellHeaderPanel.setBackground(Color.RED);

        Label sellHeaderLabel = new Label();
        sellHeaderLabel.setText("Welcome to the shop! Here you can sell your crops for $");
        sellHeaderLabel.setBackground(Color.BLUE);
        sellHeaderPanel.add(sellHeaderLabel);

        sellPanel.add(sellHeaderPanel);

        for (int i = 0; i < gameInformation.getCrops().size(); i++) {
            //Panel pr crop to sell
            Panels cropPanel = new Panels(600, 35);
            cropPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
            cropPanel.setBackground(Color.GREEN);

            //Name of crop to sell
            Buttons button = new Buttons();
            button.setPreferredSize(cropNameBoxSize);
            button.setText(gameInformation.getCrops().get(i).getName());
            cropPanel.add(button);

            //Sell button 1x
            SellCropButton sellCropButton1x = new SellCropButton();
            sellCropButton1x.setPreferredSize(cropSellBoxSize);
            sellCropButton1x.setText("Sell 1x");
            cropPanel.add(sellCropButton1x);

            //Sell button 10x
            SellCropButton sellCropButton10x = new SellCropButton();
            sellCropButton10x.setPreferredSize(cropSellBoxSize);
            sellCropButton10x.setText("Sell 10x");
            cropPanel.add(sellCropButton10x);

            //sell button 100x
            SellCropButton sellCropButton100x = new SellCropButton();
            sellCropButton100x.setPreferredSize(cropSellBoxSize);
            sellCropButton100x.setText("Sell 100x");
            cropPanel.add(sellCropButton100x);

            //Info about crop pricing
            Buttons infoButton = new Buttons();
            infoButton.setPreferredSize(new Dimension(225, 25));
            infoButton.setText("1x " + gameInformation.getCrops().get(i).getName() + " sells for: 1$");
            cropPanel.add(infoButton);

            sellPanel.add(Box.createVerticalStrut(10));
            sellPanel.add(cropPanel);
        }
        return sellPanel;
    }
}