package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class centerPanels extends JPanel {
    private ArrayList<PlotButton> cropButtons;
    private CardLayout cardLayout;

    public static final String plotScreen = "plotScreen";
    public static final String sellScreen = "sellScreen";

    public centerPanels() {
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
        centerPlotPanel.setOpaque(true);
        return centerPlotPanel;
    }

    //Still missing actual sell screen
    public Panels centerSellPanel() {
        Panels sellPanel = new Panels(200, 200);
        sellPanel.backGroundImg("Assets/SkyBackgroundNoSun.png");
        return sellPanel;
    }
}