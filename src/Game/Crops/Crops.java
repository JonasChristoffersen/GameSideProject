package Game.Crops;

import Game.GameInformation;
import Game.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;
import java.util.TimerTask;
import java.util.function.DoubleToIntFunction;
import java.util.function.Supplier;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;


public abstract class Crops implements ActionListener {
    private final String name;
    private final int points;
    private int counter;
    private final ImageIcon image;
    private int timePassed = 0;
    private Timer timer;

    Crops(String name, int points, ImageIcon image) {
        this.name = name;
        this.points = points;
        this.image = image;
        timer = new Timer(1000, e -> {
            if (timePassed < 10) {
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
       if(timePassed > 6) {
           GameInformation.addPoints(type.getPoints() + 3);
           System.out.println(type.getName() +"Stage 3:" + (type.getPoints() + 3));
           timePassed= 0;
       }
        else if (timePassed > 3) {
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

    public int getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed += timePassed;
    }

    private void run() {
        while (timePassed < 10) {
            timePassed++;
            System.out.println("test");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
