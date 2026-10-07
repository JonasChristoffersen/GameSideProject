package Saves;

import java.io.FileWriter;
import java.io.IOException;

import Game.GameInformation;

public class SaveGame {

    //Easy to scall up for storing more data!
    public void endGameAndSave() {
            try {
                FileWriter writer = new FileWriter("src/Saves/SavedData.csv");
                writer.write("Points");
                writer.write("\n" + GameInformation.getPoints());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

    }
}



