package Game.Upgrades;

import Game.Crops.Crops;
import Game.GameInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Upgrades implements ActionListener {
    private String name;
    private int pointsPerSecond;
    private int cost;
    private static int amount;
    //TODO: add icon for upgrades.
    Upgrades(String name, int pointsPerSecond, int cost) {
        this.name = name;
        this.pointsPerSecond = pointsPerSecond;
        this.cost = cost;
    }

    public void actionPerformed(Upgrades type){
        GameInformation.addPointsPerSecond(type.getPointsPerSecond());
        GameInformation.buy(type.getCost());
        System.out.println(type.getPointsPerSecond());
        System.out.println(GameInformation.getPointsPerSecond());

        amount++;
        increaseCost();


    }

    public void actionPerformed(ActionEvent e) {

    }

    public int getCost() {
        return cost;
    }

    public int getPointsPerSecond() {
        return pointsPerSecond;
    }

    public String getName() {
        return name;
    }

    //Made this static to be able to save data in CSV file
    public static int getAmount() {
        return amount;
    }

    //Tried to create this method for loading data (Not working yet)
    public static void setAmount(int amount) {
        Upgrades.amount = amount;
    }

    public void increaseCost(){
        cost *= 1.1;
    }
}
