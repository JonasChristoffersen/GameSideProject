package Game;

public class GameInformation {
    private static int points = 0;
    private static String nameOfGame = "Crop Clikker A/S";

    public static int getPoints() {
        return points;
    }

    public static String getNameOfGame() {
        return nameOfGame;
    }

    public static void setPoints(int points) {
        points = points;
    }

    public static void addPoints(int points) {
        points += points;
    }
}
