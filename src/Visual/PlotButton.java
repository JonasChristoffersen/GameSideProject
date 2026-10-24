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
    private JProgressBar progressBar;

    public PlotButton(Plot plot, GameInformation gameInformation) {
        this.gameInformation = gameInformation;
        this.plot = plot;
        this.setPreferredSize(new Dimension(200, 200));
        this.setVerticalAlignment(SwingConstants.TOP);
        this.setLayout(new BorderLayout());
        this.setIconTextGap(15);

        this.setText(plot.getCrop().getName());
        this.setVerticalTextPosition(SwingConstants.TOP);
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        this.setIcon(plot.getCrop().getImage());

        this.progressBar = new JProgressBar(0, plot.getCrop().getFullGrown());
        this.add(progressBar, BorderLayout.SOUTH);

        timer = new Timer(1000, e -> {
            if ( timePassed < plot.getCrop().getFullGrown()) {
                progressBar.setValue(timePassed);
                System.out.println(plot.getCrop().getName() + ": Time passed: " + timePassed);
                timePassed++;
            }
            else {
                progressBar.setValue(timePassed);
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
