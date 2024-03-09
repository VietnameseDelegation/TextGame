package Items;

public class Food extends Items{
     private int health;
     private String[] names ={"dubious food","rock solid food","raw potato","nutrient bar","schnitzel","meat buns","medical herb"};
    public Food(int health, TypeOfItem item) {
        this.name = names[rd.nextInt(7)];
        this.health = health;
        this.typeOfItem = item;
    }

    @Override
    public int effect(int playerHealth) {
        playerHealth = playerHealth + health;
        return playerHealth;
    }

    @Override
    public String toString() {
        return "Increasing health = " + health + ", name = " + name;
    }
}
