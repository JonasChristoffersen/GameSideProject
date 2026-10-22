package Game;

import Crops.Crops;
import Upgrades.Upgrades;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GameInformation {
    private double points;
    private int pointsPerSecond;
    private int level;
    private String nameOfGame = "Crop Clikker A/S";
    private String savedMoneyData = "src/Saves/savedMoneyData.csv";
    private String savedUpgradeData = "src/Saves/savedUpgradeData.csv";

    private ArrayList<Plot> plots;
    private ArrayList<Crops> crops;

    public GameInformation() {
        this.plots = new ArrayList<>();
        this.crops = new ArrayList<>();
        createCrops();
        createPlots();
    }

    public double getPoints() {
        return points;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void addPoints(double point) {
        points += point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSavedMoneyDataPath() {
        return savedMoneyData;
    }

    public String getSavedUpgradeDataPath() {
        return savedUpgradeData;
    }

    public int getPointsPerSecond() {
        return pointsPerSecond;
    }

    public void setPointsPerSecond(int pointsPerSecond) {
        this.pointsPerSecond = pointsPerSecond;
    }

    public void addPointsPerSecond(int amount) {
        pointsPerSecond += amount;
    }

    public void buy(int amount) {
        points -= amount;
    }

    public void createPlots() {
        for(Crops c : crops) {
            plots.add(new Plot(c));
        }

    }

    public void createCrops(){
        crops.add(new Crops("Wheat", 1, new ImageIcon("Assets/minecraftwheat2.png"), 10));
        crops.add(new Crops("Tomatoes", 2, new ImageIcon("Assets/minecrafttomatoes.png"), 30));
    }

    public ArrayList<Crops> getCrops() {
        return crops;
    }


    public ArrayList<Plot> getPlots() {
        return plots;
    }
}
