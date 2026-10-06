import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Crop Clicker A/S", null);
        //window.setlo
        window.setVisible(true);
        window.setSize(600,600);
        window.setResizable(false); //Maybe make resizeable at some point?
        JButton j1 = new JButton("hvede", );
        j1.setBounds(100,300,300,200);
        JPanel panel = new JPanel(null);
        panel.setBounds(100,100,300,300);



        panel.add(j1);
        window.add(panel);


        //j1.setLocation(300,500);
        //window.add(j1);
        //window.getContentPane().add(new JButton());
    }
}