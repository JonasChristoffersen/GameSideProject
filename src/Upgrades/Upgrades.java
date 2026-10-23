package Upgrades;
import Game.GameInformation;

public class Upgrades {
    private String name;
    private int pointsPerSecond;
    private int cost;
    private int amount;
    //TODO: add icon for upgrades.
    public Upgrades(String name, int pointsPerSecond, int cost) {
        this.name = name;
        this.pointsPerSecond = pointsPerSecond;
        this.cost = cost;
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

    public void increaseAmount(int amount) {
        this.amount += amount;
    }

    public void increaseCost(){
        cost *= 1.1;
    }

    public void setPrice(int amount) {
        this.cost = amount;
    }
}
