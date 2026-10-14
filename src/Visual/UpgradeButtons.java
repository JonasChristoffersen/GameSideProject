package Visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Game.GameInformation;
import Upgrades.Upgrades;

import javax.swing.*;

public class UpgradeButtons extends Buttons{
    private Upgrades upgrade;
    private GameInformation gameInformation;

    public UpgradeButtons(Upgrades upgrade, GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.upgrade = upgrade;
        this.setPreferredSize(new Dimension(200, 100));
        this.setLayout(null);
        this.setEnabled(false);
        this.setText(upgrade.getName());

        JLabel upgradeCountLabel = new JLabel();
        upgradeCountLabel.setBounds(180,0,20,20);
        upgradeCountLabel.setText(String.valueOf(upgrade.getAmount()));
        this.add(upgradeCountLabel);

        JLabel upgradeCostLabel = new JLabel();
        upgradeCostLabel.setBounds(80, 70, 100, 20);
        upgradeCostLabel.setText("Cost: " + upgrade.getCost());
        this.add(upgradeCostLabel);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgrade.actionPerformed(upgrade, gameInformation);
                upgradeCountLabel.setText(String.valueOf(upgrade.getAmount()));
                upgradeCostLabel.setText("Cost: " + upgrade.getCost());
            }
        });


    }

    public void refresh() {
        if (gameInformation.getPoints() >= upgrade.getCost()) {
            this.setEnabled(true);
        } else {
            this.setEnabled(false);
        }
    }


}
