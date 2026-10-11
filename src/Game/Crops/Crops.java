package Game.Crops;

import Game.GameInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.DoubleToIntFunction;
import java.util.function.Supplier;


public abstract class Crops implements ActionListener {
    private String name;
    private int points;
    private int counter;
    private ImageIcon image;
    private int timePassed = 1;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            timePassed++;
            if (timePassed == 10) {
                timer.purge();
                System.out.println("Task has been stopped for" + name);
            }
        }

    };

    Crops(String name, int points, ImageIcon image) {
        this.name = name;
        this.points = points;
        this.image = image;
        timer.scheduleAtFixedRate(task,0,1000);
    }

    public void actionPerformed(Crops type){
        timer.purge();
        System.out.println(timePassed);
       if(timePassed > 6) {
           GameInformation.addPoints(type.getPoints() + 3);
           System.out.println("Stage 3:" + (type.getPoints() + 3));
           timePassed= 0;
       }
        else if (timePassed > 3) {
            GameInformation.addPoints(type.getPoints() + 1);
            System.out.println("Stage 2: " + (type.getPoints() + 1));
            timePassed = 0;
        }
        else {
        GameInformation.addPoints(type.getPoints());
        System.out.println("Stage 1;" + type.getPoints());
        timePassed = 0;
    }
        try {
            timer.scheduleAtFixedRate(task, 0, 1000);
        } catch (Exception e) {

        }



    }

    public void actionPerformed(ActionEvent e) {

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
