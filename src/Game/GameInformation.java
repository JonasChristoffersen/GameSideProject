package Game;

import Crops.Crop;

import javax.swing.*;
import java.util.ArrayList;

public class GameInformation {
    private double points;
    private int pointsPerSecond;
    private int level;
    private String nameOfGame = "Crop Clikker A/S";
    private String savedMoneyData = "src/Saves/savedMoneyData.csv";
    private String savedUpgradeData = "src/Saves/savedUpgradeData.csv";

    private ArrayList<Plot> plots;
    private ArrayList<Crop> crops;


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
        for(Crop c : crops) {
            plots.add(new Plot(c));
        }
        plots.add(new Plot(crops.get(1)));
    }

    private void createCrops(){
        crops.add(new Crop("Wheat", new ImageIcon("Assets/minecraftwheat2.png"), 2));
        crops.add(new Crop("Tomatoes", new ImageIcon("Assets/minecrafttomatoes.png"), 10));
        crops.add(new Crop("weed", null, 2));


    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }


    public ArrayList<Plot> getPlots() {
        return plots;
    }
}
