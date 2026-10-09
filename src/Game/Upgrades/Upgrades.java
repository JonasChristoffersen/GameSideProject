package Game.Upgrades;

import Game.Crops.Crops;
import Game.GameInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Upgrades implements ActionListener {
    private String name;
    private int pointsPerSecond;
    private int cost;
    private int amount;
    //TODO: add icon for upgrades.
    Upgrades(String name, int pointsPerSecond, int cost) {
        this.name = name;
        this.pointsPerSecond = pointsPerSecond;
        this.cost = cost;
        this.amount = 0;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseCost(){
        cost *= 1.1;
    }
}
