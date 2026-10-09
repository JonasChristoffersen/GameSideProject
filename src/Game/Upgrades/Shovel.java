package Game.Upgrades;

public class Shovel extends Upgrades {
    //private static int amount = 0;

    public Shovel() {
        super("Shovel", 1, 20);
    }
/*
    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        Shovel.amount = amount;
    }*/

    //Skal shovel eje amount? -> Så undgår vi at alle upgrades kommer til at have samme amount.
    //Hvis vi går dette skal vi fortsat kigge på hvordan at upgrades bliver oprettet.
    //Hvis ikke skal vi udtænke en helt anden løsning.
}
