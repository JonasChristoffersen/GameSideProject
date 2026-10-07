package Saves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadSavedData {
    public void loadSave(String path) {
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.hasNextLine(); //Skip header in CSV file!
            String s = scan.nextLine();
            String[] values = s.split(", ");




        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}
