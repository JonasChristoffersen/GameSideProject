package Crops;
import Game.GameInformation;
import javax.swing.*;


public class Crops{
    private final String name;
    private final int points;
    private int counter;
    private final ImageIcon image;
    private int timePassed = 0;
    private int fullGrown;
    private Timer timer;
    private int amount;

    public Crops(String name, int points, ImageIcon image, int fullGrown) {
        this.name = name;
        this.points = points;
        this.image = image;
        this.fullGrown = fullGrown;

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
        growthLogic();
        timePassed = 0;
        timer.restart();

    }

    public int growthLogic(){
        if (this.timePassed == this.fullGrown) {
            return this.getPoints() * 3 ;
        }
        if(this.timePassed > (this.fullGrown / 2)) {
            return this.getPoints() * 2;
        }
        return 0;

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

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
        timer.restart();
    }
}
