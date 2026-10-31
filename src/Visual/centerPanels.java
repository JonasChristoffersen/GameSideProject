package Visual;

import Game.GameInformation;
import Visual.Clickables.Buttons;
import Visual.Clickables.PlotButton;
import Visual.Clickables.SellCropButton;
import org.ietf.jgss.GSSManager;

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
        sellHeaderPanel.backGroundImg("Assets/GlassPanel.png");
        sellHeaderPanel.setOpaque(false);

        Label sellHeaderLabel = new Label();
        sellHeaderLabel.setText("Welcome to the shop! Here you can sell your crops for $");
        sellHeaderPanel.add(sellHeaderLabel);

        sellPanel.add(sellHeaderPanel);

        for (int i = 0; i < gameInformation.getCrops().size(); i++) {
            //Panel pr crop to sell
            Panels cropPanel = new Panels(600, 35);
            cropPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
            cropPanel.backGroundImg("Assets/GlassPanel.png");
            cropPanel.setLayout(new BoxLayout(cropPanel, BoxLayout.X_AXIS));
            cropPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            cropPanel.setOpaque(false);

            //Name of crop to sell
            Buttons button = new Buttons();
            button.setPreferredSize(cropNameBoxSize);
            button.setText(gameInformation.getCrops().get(i).getName());
            button.backGroundImg("Assets/ButtonName.png");
            button.setBorder(BorderFactory.createEmptyBorder());
            makeStretchable(button, cropNameBoxSize);
            cropPanel.add(button);

            //sell buttons
            int[] sellAmountNumber = {1, 10, 100};
            for (int s = 0; s < sellAmountNumber.length; s++) {
                SellCropButton sellCropButton = new SellCropButton(gameInformation.getCrops().get(i), gameInformation, sellAmountNumber[s]);
                sellCropButton.setPreferredSize(cropSellBoxSize);
                sellCropButton.setText("Sell " + sellAmountNumber[s] + "x");
                sellCropButton.backGroundImg("Assets/ButtonSell.png");
                sellCropButton.setBorder(BorderFactory.createEmptyBorder());
                makeStretchable(sellCropButton, cropSellBoxSize);
                cropPanel.add(Box.createHorizontalStrut(5));
                cropPanel.add(sellCropButton);
            }

            //Info about crop pricing
            Buttons infoButton = new Buttons();
            infoButton.setPreferredSize(new Dimension(225, 25));
            infoButton.setText("1x " + gameInformation.getCrops().get(i).getName() + " sells for: 1$");
            infoButton.backGroundImg("Assets/ButtonInfo.png");
            infoButton.setBorder(BorderFactory.createEmptyBorder());
            makeStretchable(infoButton, new Dimension(225, 25));
            cropPanel.add(Box.createHorizontalStrut(5));
            cropPanel.add(infoButton);

            sellPanel.add(Box.createVerticalStrut(10));
            sellPanel.add(cropPanel);
        }
        return sellPanel;
    }

    private void makeStretchable(JComponent component, Dimension preferred) {
        component.setPreferredSize(preferred);
        component.setMinimumSize(new Dimension(20, preferred.height));
        component.setMaximumSize(new Dimension(Integer.MAX_VALUE, preferred.height));
    }
}