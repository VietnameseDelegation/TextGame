package Items;

import java.util.ArrayList;
import java.util.Random;

public class Items {
    protected String name;
    Random rd = new Random();
    protected TypeOfItem typeOfItem;

    public Items() {
    }

    public TypeOfItem getTypeOfItem() {
        return typeOfItem;
    }

    public Items createLoot(int rng, int damage) {
        switch (rng) {
            case 0: return new Weapon(damage,rd.nextInt(6)+2,TypeOfItem.WEAPON);
            case 1: return new Food(rd.nextInt(6)+1,TypeOfItem.FOOD);
            default: return null;
        }
    }

    public Items(String name,TypeOfItem typeOfItem) {
        this.name = name;
        this.typeOfItem = typeOfItem;
    }

    public int effect(int health){
        return health;
    }
    public int effect(){
        return 0;
    }
}
