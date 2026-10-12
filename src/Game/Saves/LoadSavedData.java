package Game.Saves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Game.GameInformation;
import Game.Upgrades.CreateUpgrades;

//Created with scalability in mind (Therefore a while loop that could handle multiple players)
public class LoadSavedData {
    public void loadSave() {
        File file = new File(GameInformation.getSavedDataPath());
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header in CSV file!
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] values = s.split(",");
                GameInformation.setPoints(Integer.parseInt(values[0].trim())); //Sets points to saved amount
                GameInformation.setLevel(Integer.parseInt(values[1].trim())); //Sets level to saved amount
                CreateUpgrades.setAmount(CreateUpgrades.getShovel(), Integer.parseInt(values[3].trim())); //Sets shovel to saved amount
                CreateUpgrades.setAmount(CreateUpgrades.getBucket(), Integer.parseInt(values[4].trim())); //Sets bucket to saved amount
                GameInformation.loadPointsPerSecond(); //Sets pointsPerSec
            }
        } catch (FileNotFoundException e) {
            GameInformation.setPoints(0); //If no file is found, set points to 0
            GameInformation.setLevel(0); //If no file is found, set level to 0
            CreateUpgrades.setAmount(CreateUpgrades.getShovel(),0); //If no file is found, set shovel amount to 0
            CreateUpgrades.setAmount(CreateUpgrades.getBucket(),0); //If no file is found, set bucket amount to 0
            System.out.println(e.getMessage());
        }
    }
}