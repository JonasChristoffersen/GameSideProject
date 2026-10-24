package Game;

public class Main {
    public static void main(String[] args) {
        GameInformation gameInformation = new GameInformation();
        Saves.SaveManager saveManager = new Saves.SaveManager(gameInformation);
        Visual.UI ui = new Visual.UI(gameInformation, saveManager);

        ui.makeUI();
    }
}