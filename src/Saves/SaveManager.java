package Saves;

import Game.GameInformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveManager {
    private GameInformation gameInformation;

    public SaveManager(GameInformation gameInformation) {
        this.gameInformation = gameInformation;
    }
    public void userSaveAction() {
        //Handle "SavedMoneyData.csv" data
        try {
            FileWriter writer = new FileWriter(gameInformation.getSavedMoneyDataPath());
            writer.write("Points, MoneyPerSecond, Level");
            writer.write("\n" + gameInformation.getPoints()
                    + ", " + gameInformation.getPointsPerSecond()
                    + ", " + gameInformation.getLevel()
            );
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Handle "SavedUpgradeData.csv" data
        try {
            FileWriter writer = new FileWriter(gameInformation.getSavedUpgradeDataPath());
            for (int i = 0; i < gameInformation.getUpgrades().size(); i++) {
                if(i < gameInformation.getUpgrades().size() - 1) {
                    writer.write(gameInformation.getUpgrades().get(i).getName() + ", ");
                }else {
                    writer.write(gameInformation.getUpgrades().get(i).getName());
                }
            }
            writer.write("\n");

            for (int i = 0; i < gameInformation.getUpgrades().size(); i++) {
                if(i < gameInformation.getUpgrades().size() - 1) {
                    writer.write(gameInformation.getUpgrades().get(i).getAmount() + ", ");
                }else {
                    writer.write(String.valueOf(gameInformation.getUpgrades().get(i).getAmount()));
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadSave() {
        File moneyFile = new File(gameInformation.getSavedMoneyDataPath());
        try {
            Scanner scan = new Scanner(moneyFile);
            scan.nextLine(); //Skip header in CSV file!
            while (scan.hasNextLine()) {
                String s = scan.nextLine().replaceAll("\\s+", "");
                String[] values = s.split(",");
                gameInformation.setPoints(Double.parseDouble(values[0])); //Sets money to saved amount
                gameInformation.setPointsPerSecond(Integer.parseInt(values[1])); //Sets pointsPerSec
                gameInformation.setLevel(Integer.parseInt(values[2])); //Sets level to saved amount


            }
        } catch (FileNotFoundException e) {
            gameInformation.setPoints(0); //If no file is found, set points to 0
            gameInformation.setLevel(0); //If no file is found, set level to 0
            System.out.println(e.getMessage() + " (Money file)");
        }
        File upgradeFile = new File(gameInformation.getSavedUpgradeDataPath());


        try {
            Scanner scan = new Scanner(upgradeFile);
            scan.nextLine();
            String line = scan.nextLine().replaceAll("\\s+", "");
            String[] upgradeAmount = line.split(",");
            for (int i = 0; i < gameInformation.getUpgrades().size(); i++) {
                gameInformation.getUpgrades().get(i).setAmount(Integer.parseInt(upgradeAmount[i]));
                if (gameInformation.getUpgrades().get(i).getAmount() > 0) {
                    gameInformation.getUpgrades().get(i).setPrice((int) (gameInformation.getUpgrades().get(i).getCost() * Math.pow(1.1, gameInformation.getUpgrades().get(i).getAmount())));
                }
            };

        }catch (FileNotFoundException e) {
            for (int i = 0; i < gameInformation.getUpgrades().size(); i++) {
                gameInformation.getUpgrades().get(i).setAmount(0);
            }
            System.out.println(e.getMessage() + " (Upgrade file)");
        }
    }
}