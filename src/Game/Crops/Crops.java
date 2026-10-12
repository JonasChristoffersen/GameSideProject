package Game.Crops;
import Game.GameInformation;
import javax.swing.*;
import java.awt.*;


public abstract class Crops{
    private final String name;
    private final int points;
    private int counter;
    private final ImageIcon image;
    private int timePassed = 0;
    private int fullgrown;
    private Timer timer;

    Crops(String name, int points, ImageIcon image, int fullGrown) {
        this.name = name;
        this.points = points;
        this.image = image;
        this.fullgrown = fullGrown;
        timer = new Timer(1000, e -> {
            if (timePassed < fullGrown) {
                System.out.println(name + ": Time passed: " + timePassed);
                timePassed++;
            }
            else {
                System.out.println(name + ": is full grown");
                timer.stop();
            }
        });
        timer.start();

    }

    public void actionPerformed(Crops type){
       if(timePassed == fullgrown) {
           GameInformation.addPoints(type.getPoints() + 3);
           System.out.println(type.getName() +"Stage 3:" + (type.getPoints() + 3));
           timePassed= 0;
       }
        else if (timePassed > (fullgrown / 2)) { //Halfgrown
            GameInformation.addPoints(type.getPoints() + 1);
            System.out.println(type.getName() +"Stage 2: " + (type.getPoints() + 1));
            timePassed = 0;
        }
        else {
        GameInformation.addPoints(type.getPoints());
        System.out.println(type.getName() + " Stage 1;" + type.getPoints());
        timePassed = 0;
    }
        timer.restart();

    }


    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }


}
