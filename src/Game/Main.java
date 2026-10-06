package Game;

import javax.swing.*;
import java.awt.*;

public class Main {
    static int count = 0;
    static int point = 0;
    public int  counter = 1
    public static void main(String[] args) {
        JFrame window = new JFrame("Crop Clicker A/S");
        //window.setlo
        window.setVisible(true);
        window.setLayout(null);
        window.setSize(600,600);
        window.setResizable(false); //Maybe make resizeable at some point?


        JButton m1 = makeCrop("hvede");
        JButton m2 = makeCrop("test");
        JPanel mainGame = new JPanel();

        JLabel l1 = new JLabel(Integer.toString(point));
        m1.addActionListener(e -> point++);
        m1.addActionListener(e -> l1.setText(Integer.toString(point)));
        l1.setBounds(100,300, 100,100);
        mainGame.add(l1);

        mainGame.setBounds(400,0,200,600);
        mainGame.setBackground(Color.red);
        mainGame.setLayout(null);
        mainGame.add(m1);
        mainGame.add(m2);

        window.add(mainGame);
        //j1.setLocation(300,500);
        //window.add(j1);
        //window.getContentPane().add(new JButton());
    }

    public static JButton makeCrop(String name) {
        JButton m1 = new JButton(name);
        m1.setBounds(0, getY(), 200, 50);
        return m1;
    }

    private static int getY() {
        int x = 50 * count;
        count++;
        return x;
    }




}