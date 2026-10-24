package Visual;

import Crops.Crop;
import Game.GameInformation;
import Game.Plot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlotButton extends Buttons{
    private Plot plot;
    private GameInformation gameInformation;
    private Timer timer;
    private int timePassed = 0;



    public PlotButton(Plot plot, GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.plot = plot;
        this.setText(plot.getCrop().getName());
        this.setPreferredSize(new Dimension(200, 200));
        this.setIcon(plot.getCrop().getImage());
        timer = new Timer(1000, e -> {
            if ( timePassed < plot.getCrop().getFullGrown()) {
                System.out.println(plot.getCrop().getName() + ": Time passed: " + timePassed);
                timePassed++;
            }
            else {
                System.out.println(plot.getCrop().getName() + ": is full grown");
                timer.stop();
            }
        });
        timer.setInitialDelay(0);
        timer.start();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plot.getCrop().addAmount(growthLogic(plot.getCrop()));
                setTimePassed(0);
            }
        });
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
        timer.restart();
    }
    public int growthLogic(Crop crop){
        if (this.timePassed == crop.getFullGrown()) {
            return 3 ;
        }
        if(this.timePassed > (crop.getFullGrown() / 2)) {
            return  2;
        }
        return 1;
    }




}
