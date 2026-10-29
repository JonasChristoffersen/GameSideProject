package Visual.Clickables;

import Game.GameInformation;
import Saves.SaveManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButton extends Buttons{
    private GameInformation gameInformation;
    private SaveManager saveManager;

    public SaveButton(GameInformation gameInformation, SaveManager saveManager) {
        this.gameInformation = gameInformation;
        this.saveManager = saveManager;
        this.setPreferredSize(new Dimension(150, 40));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveManager.userSaveAction();
            }
        });
    }



}
