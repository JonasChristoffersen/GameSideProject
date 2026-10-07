package Game.Visual;

import Game.Crops.Crops;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class Buttons extends JButton{
    private Crops crop;


    Buttons(int x, int y, int w, int h, Supplier<Crops> cropsSupplier) {
        this.crop = cropsSupplier.get();
        this.setText(crop.getName());
        this.setBounds(x,y,w,h);
        this.setIcon(crop.getImage());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crop.actionPerformed(crop);
            }
        });
    }

    public Buttons getButton() {
        return this;
    }


}
