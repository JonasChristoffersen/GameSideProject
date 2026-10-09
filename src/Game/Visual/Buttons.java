package Game.Visual;

import Game.Crops.Crops;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

import Game.GameInformation;
import Game.Saves.SaveGame;
import Game.Upgrades.Upgrades;

public class Buttons extends JButton{
    private Crops crop;
    private Upgrades upgrade;
    private Timer timer;
    private TimerTask task;
    private SaveGame saveGame = new SaveGame();

    //Plot buttons
    Buttons(int x, int y, int w, int h, Supplier<Crops> cropsSupplier) {
        this.crop = cropsSupplier.get();
        this.setText(crop.getName());
        this.setBounds(x,y,w,h);
        this.setIcon(crop.getImage());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crop.actionPerformed(crop);
            }
        });
    }

    //Used for saving the game
    Buttons(int x, int y, int w, int h) {
        this.setBounds(x,y,w,h);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame.userSaveAction();
            }
        });
    }

    //Upgrade buttons
    Buttons(int x, int y, int w, int h, Upgrades upgrade) {
        this.setBounds(x,y,w,h);
        this.setLayout(null);
        this.setEnabled(false);
        this.setText(upgrade.getName());
        JLabel upgradeCount = new JLabel();
        this.add(upgradeCount);
        upgradeCount.setBounds(180,0,20,20);
        upgradeCount.setText(String.valueOf(upgrade.getAmount()));
        JLabel upgradeCost = new JLabel();
        upgradeCost.setBounds(80, 70, 100, 20);
        upgradeCost.setText("Cost: " + upgrade.getCost());
        this.add(upgradeCost);
        this.upgrade = upgrade;

        this.timer = new Timer();
        this.task = new TimerTask() {
            @Override
            public void run() {
                if (GameInformation.getPoints() >= upgrade.getCost()) {
                    getButton().setEnabled(true);
                } else {
                    getButton().setEnabled(false);
                }
            }
        };
        this.timer.schedule(task, 0, 100);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgrade.actionPerformed(upgrade);
                upgradeCount.setText(String.valueOf(upgrade.getAmount()));
                upgradeCost.setText("Cost: " + upgrade.getCost());
                UI.updateMoneyPerSecond();
            }
        });


    }


    public Buttons getButton() {
        return this;
    }


}
