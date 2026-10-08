package Game.Saves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Game.GameInformation;

//Created with scalability in mind (Therefore a while loop that could handle multiple players)
public class LoadSavedData {
    public static void loadSave() {
        File file = new File(GameInformation.getSavedDataPath());
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header in CSV file!
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] values = s.split(",");
                GameInformation.setPoints(Integer.parseInt(values[0].trim())); //Sets points to saved amount
                GameInformation.setLevel(Integer.parseInt(values[1].trim())); //Sets level to saved amount
                Game.Upgrades.Upgrades.setAmount(Integer.parseInt(values[2].trim())); //Sets shovel amount (Not setup correctly, data is not loaded in and user start at 0 every time)
            }
        } catch (FileNotFoundException e) {
            GameInformation.setPoints(0); //If no file is found, set points to 0
            GameInformation.setLevel(0); //If no file is found, set level to 0
            Game.Upgrades.Upgrades.setAmount(0); //If no file is found, set shovel amount to 0 (Not setup correctly, data is not loaded in and user start at 0 every time)
            System.out.println(e.getMessage());
        }
    }
}