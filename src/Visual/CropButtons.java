package Visual;

import Crops.Crops;
import Game.GameInformation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CropButtons extends Buttons{
    private Crops crop;
    private GameInformation gameInformation;


    public CropButtons(Crops crop, GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.crop = crop;
        this.setText(crop.getName());
        this.setPreferredSize(new Dimension(200, 200));
        this.setIcon(crop.getImage());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInformation.addPoints(crop.getPoints() + crop.growthLogic());
                crop.setTimePassed(0);
            }
        });
    }

}
