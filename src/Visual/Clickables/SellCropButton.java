package Visual.Clickables;

import Crops.Crop;
import Game.GameInformation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellCropButton extends Buttons{
    private GameInformation gameInformation;
    private Crop crop;

    public SellCropButton(Crop crop, GameInformation gameInformation, int sellAmount) {
        this.gameInformation = gameInformation;
        this.crop = crop;
        this.setPreferredSize(new Dimension(150, 40));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (crop.getAmount() >= sellAmount) {
                    crop.subtractAmount(sellAmount);
                    gameInformation.addPoints(sellAmount); //Amount per crop is not specified - Therefore 1 for all at this point
                }
            }
        });
    }
}
