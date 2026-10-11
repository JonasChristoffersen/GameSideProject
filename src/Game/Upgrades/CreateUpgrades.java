package Game.Upgrades;

public class CreateUpgrades {
    private static Shovel shovel = new Shovel();
    private static Bucket bucket = new Bucket();

    public static void setAmount(Upgrades upgradeItem, int amount) {
        upgradeItem.setAmount(amount);
    }
    public static void setStartAmount(Upgrades upgrades){
        if (upgrades.getAmount() == 0) {
            upgrades.setPrice(upgrades.getCost());
        }
        else {
            upgrades.setPrice(upgrades.getCost() * (int) (upgrades.getAmount() * 1.1));
        }
    }

    public static Shovel getShovel() {
        return shovel;
    }

    public static Bucket getBucket() {
        return bucket;
    }
}
