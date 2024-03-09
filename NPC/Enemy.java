package NPC;
import Items.*;
import player.Player;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

     private final int damage;
     private int health;
     private String name;

     private String[] names = {"Goblin","Python","Statue","Skeleton","Ghoul","Troll"};



    public Enemy() {
        Random rd = new Random();
        this.name = names[rd.nextInt(6)];
        this.damage = rd.nextInt(9)+1;
        this.health = rd.nextInt(10)+1;
    }
    public Enemy(boolean boss){
        this.damage = 3;
        this.health = 20;
    }
    public void damage(Player player){
        player.setHealth(player.getHealth()-damage);
    }

    @Override
    public String toString() {
        return
                "damage=" + damage +
                ", health=" + health +
                ", name='" + name;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
