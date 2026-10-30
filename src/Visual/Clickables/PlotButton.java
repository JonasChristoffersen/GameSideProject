package Visual.Clickables;

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
    private boolean isUnlocked;
    private int timePassed = 0;
    private JProgressBar progressBar;

    public PlotButton(Plot plot, GameInformation gameInformation, boolean isUnlockeda, boolean isVisible) {
        this.gameInformation = gameInformation;
        this.plot = plot;
        this.setVisible(isVisible);
        setText(this.plot.getCrop().getName());
        this.backGroundImg("Assets/FarmLandPlotTexture.png");
        this.setForeground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder());
        if(!isUnlockeda) {
            setText("\n COSTS: \n" + gameInformation.getCrops().get(plot.getId() - 1).getName() + " " + plot.getCost());

        }
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
        if(isUnlocked) {
            timer.setInitialDelay(0);
            timer.start();
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isUnlocked) {
                    plot.getCrop().addAmount(growthLogic(plot.getCrop()));
                    setTimePassed(0);
                }
                else {
                    SetTrue();
                    if(plot.getId() > 0) {
                        gameInformation.getPlots().get(plot.getId() - 1).getCrop().buy(plot.getCost());
                        gameInformation.increaseUnlockedPlotCount(1);
                    }
                    setText();
                }
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

    public void refresh() {
        boolean t = gameInformation.getCrops().get(plot.getId() - 1).getAmount()  >= plot.getCost();
        if (t) {
            this.setEnabled(true);
        } else {
            this.setEnabled(false);
        }
    }

    public void setText() {
        this.setText(plot.getCrop().getName());
    }

    public void SetTrue() {
        this.isUnlocked = true;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

}
