package Visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Game.GameInformation;
import Upgrades.Upgrades;

import javax.swing.*;

public class UpgradeButtons extends Buttons{
    private Upgrades upgrade;

    public UpgradeButtons(Upgrades upgrade, GameInformation gameInformation) {
        super(gameInformation);
        this.upgrade = upgrade;
        this.setPreferredSize(new Dimension(200, 100));
        this.setLayout(null);
        this.setEnabled(true); //change to false later
        this.setText(upgrade.getName());

        JLabel upgradeCountLabel = new JLabel();
        upgradeCountLabel.setBounds(180,0,20,20);
        upgradeCountLabel.setText(String.valueOf(upgrade.getAmount()));
        this.add(upgradeCountLabel);

        JLabel upgradeCostLabel = new JLabel();
        upgradeCostLabel.setBounds(80, 70, 100, 20);
        upgradeCostLabel.setText("Cost: " + upgrade.getCost());
        this.add(upgradeCostLabel);

        /*
        this.timer = new Timer();
        this.task = new TimerTask() {
            @Override
            public void run() {
                if (gameInformation.getPoints() >= upgrade.getCost()) {
                    getButton().setEnabled(true);
                } else {
                    getButton().setEnabled(false);
                }
            }
        };
        this.timer.schedule(task, 0, 100);
         */
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgrade.actionPerformed(upgrade, gameInformation);
                upgradeCountLabel.setText(String.valueOf(upgrade.getAmount()));
                upgradeCostLabel.setText("Cost: " + upgrade.getCost());
                //ui.updateMoneyPerSecond();
            }
        });


    }


}
