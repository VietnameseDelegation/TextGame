package Items;

import java.util.Random;

public class Weapon extends Items{
    private int damage;
    private  int durability;
    private String[] nam = {"Silly","Stupid","Stone","Very capable","Sturdy","Rocky","Wiggly"};
    private String[] type ={"claymore","spear","sword","polearm","scythe"};
    public Weapon(int damage,int durability,TypeOfItem item) {
        this.name = nam[rd.nextInt(7)] + " "+type[rd.nextInt(5)];
         this.damage= damage;
         this.durability = durability;
         this.typeOfItem = item;
    }

    @Override
    public int effect(){
        durability--;
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return"Name: " + name + "  Damage:" + damage +" durability: "+durability;
    }
}
