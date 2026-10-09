package Game;

import Game.Upgrades.Upgrades;

import java.util.ArrayList;

public class GameInformation {
    private static int points;
    private static int pointsPerSecond;
    private static int level;
    private static String nameOfGame = "Crop Clikker A/S";
    private static String savedDataPath = "src/Game/Saves/SavedData.csv";

    public static int getPoints() {
        return points;
    }

    public static String getNameOfGame() {
        return nameOfGame;
    }

    public static void setPoints(int points) {
        GameInformation.points = points;
    }

    public static void addPoints(int point) {
        points += point;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        GameInformation.level = level;
    }

    public static String getSavedDataPath() {
        return savedDataPath;
    }

    public static int getPointsPerSecond() {
        return pointsPerSecond;
    }

    public static void addPointsPerSecond(int amount) {
        pointsPerSecond += amount;
    }

    public static void buy(int amount) {
        points -= amount;
    }

}
