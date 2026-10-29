package Visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellButton extends Buttons {
    private final centerPanels centerPane;
    private boolean showingSellScreen = false;

    public SellButton(centerPanels centerPane) {
        this.centerPane = centerPane;
        this.setText("Sell");
        this.setPreferredSize(new Dimension(150, 40));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleScreen();
            }
        });
    }

    private void toggleScreen() {
        showingSellScreen = !showingSellScreen;
        if (showingSellScreen) {
            centerPane.showScreen(centerPanels.sellScreen);
            setText("Plots");
        } else {
            centerPane.showScreen(centerPanels.plotScreen);
            setText("Sell");
        }
    }
}