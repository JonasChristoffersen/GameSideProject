package Visual.Clickables;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Game.GameInformation;
import Upgrades.Upgrade;

import javax.swing.*;

public class UpgradeButtons extends Buttons{
    private Upgrade upgrade;
    private GameInformation gameInformation;

    public UpgradeButtons(String text, Upgrade upgrade, GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.upgrade = upgrade;
        //this.setPreferredSize(new Dimension(180, 100));
        Dimension size = new Dimension(180, 100);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setLayout(null);
        this.setEnabled(false);
        this.setText(text);
        this.backGroundImg("Assets/LargeStoneButton.png");
        this.setForeground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder());

        JLabel upgradeCountLabel = new JLabel();
        upgradeCountLabel.setBounds(140,5,20,20);
        upgradeCountLabel.setText(String.valueOf(upgrade.getAmount()));
        upgradeCountLabel.setForeground(Color.WHITE);
        this.add(upgradeCountLabel);

        JLabel upgradeCostLabel = new JLabel();
        upgradeCostLabel.setBounds(65, 70, 100, 20);
        upgradeCostLabel.setText("Cost: " + upgrade.getCost());
        upgradeCostLabel.setForeground(Color.WHITE);
        this.add(upgradeCostLabel);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInformation.addPointsPerSecond(upgrade.getCropPerSecond());
                gameInformation.buy(upgrade.getCost());
                System.out.println(upgrade.getCropPerSecond());
                System.out.println(gameInformation.getPointsPerSecond());

                upgrade.increaseAmount(1);
                upgrade.increaseCost();

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
