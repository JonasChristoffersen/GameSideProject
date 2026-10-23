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
        //Handle "savedData.CSV" data
        //Create header in CSV for each crop amount (Adds "Amount" to crop name in header)
        try {
            FileWriter writer = new FileWriter(gameInformation.getSavedDataPath());
            for (int i = 0; i < gameInformation.getCrops().size(); i++) {
                if (i < gameInformation.getCrops().size() - 1) {
                    writer.write(gameInformation.getCrops().get(i).getName() + "Amount, ");
                } else {
                    writer.write(gameInformation.getCrops().get(i).getName() + "Amount");
                }
            }
            writer.write("\n"); //Create new line for actual data in CSV file
            for (int i = 0; i < gameInformation.getCrops().size(); i++) {
                if (i < gameInformation.getCrops().size() - 1) {
                    writer.write(gameInformation.getCrops().get(i).getAmount() + ", ");
                } else {
                    writer.write(String.valueOf(gameInformation.getCrops().get(i).getAmount()));
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadSave () {
        //Handle "savedData.CSV" data
        File moneyFile = new File(gameInformation.getSavedDataPath());
        try {
            Scanner scan = new Scanner(moneyFile);
            scan.nextLine(); //Skip header in CSV file!
            String s = scan.nextLine().replaceAll("\\s+", "");
            String[] values = s.split(",");
            for (int i = 0; i< values.length; i++) {
                gameInformation.getCrops().get(i).setAmount((Integer.parseInt(values[i]))); //Sets value of cropAmount pr crop
            }
        } catch (FileNotFoundException e) {
            gameInformation.getCrops().get(0).setAmount(0); //If no file is found, set points to 0
            for (int i = 0; i< gameInformation.getCrops().size(); i++) {
                gameInformation.getCrops().get(0).setAmount(0); //Sets value of cropAmount pr crop
            }
            System.out.println(e.getMessage() + " (No data found - values set to 0!)");
        }
    }
}