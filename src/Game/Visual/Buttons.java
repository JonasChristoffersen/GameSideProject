package Game.Visual;

import Game.Crops.Crops;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class Buttons {
    private JButton button;
    private Crops crop;


    Buttons(int x, int y, int w, int h, Supplier<Crops> cropsSupplier) {
        this.crop = cropsSupplier.get();
        this.button = new JButton(crop.getName());
        setButton(x,y,w,h);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crop.actionPerformed(crop);
            }
        });


    }

    public void setButton(int x, int y, int w, int h) {
        this.button.setBounds(x,y,w,h);
    }
    public JButton getButton() {
        return button;
    }
}
