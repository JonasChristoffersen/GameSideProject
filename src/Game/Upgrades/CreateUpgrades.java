package Game.Upgrades;

public class CreateUpgrades {
    private static Shovel shovel = new Shovel();
    private static Bucket bucket = new Bucket();

    public static void setAmount(Upgrades upgradeItem, int amount) {
        upgradeItem.setAmount(amount);
    }

    public static Shovel getShovel() {
        return shovel;
    }

    public static Bucket getBucket() {
        return bucket;
    }
}
