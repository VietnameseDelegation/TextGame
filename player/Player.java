package player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import Mapa.*;
import Items.*;
import NPC.Enemy;
import commands.Move.*;

public class Player {
    private int health;
    private ArrayList<Items> backpack = new ArrayList<>();
    private String name;
    private final HashMap<String, Room> hashMap;
    private String currentPos = "0";

    public HashMap<String, Room> getHashMap() {
        return hashMap;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Player(HashMap<String, Room> hashMap) {
        this.health = 10;
        this.hashMap = hashMap;
    }


    public String moveToNorth() {
        String nextMove = hashMap.get(currentPos).getN();
        if (!Objects.equals(nextMove, "-1")) {
            setCurrentPos(nextMove);
            return nextMove;
        } else {
            return "wall";
        }
    }

    public String moveToSouth() {
        String nextMove = hashMap.get(currentPos).getS();
        if (!Objects.equals(nextMove, "-1")) {
            setCurrentPos(nextMove);
            return nextMove;
        } else {
            return "wall";
        }
    }

    public String moveToEast() {
        String nextMove = hashMap.get(currentPos).getE();
        if (!Objects.equals(nextMove, "-1")) {
            setCurrentPos(nextMove);
            return nextMove;
        } else {
            return "wall";
        }
    }

    public String moveToWest() {
        String nextMove = hashMap.get(currentPos).getW();
        if (!Objects.equals(nextMove, "-1")) {
            setCurrentPos(nextMove);
            return nextMove;
        } else {
            return "wall";
        }
    }

    // test
    public String getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(String currentPos) {
        this.currentPos = currentPos;
    }

    public void addToBackpack(Items item) {
        backpack.add(item);
    }

    public String use(int itemIndex) {
        int currentHp = backpack.get(itemIndex).effect(health);
        setHealth(currentHp);
        backpack.remove(itemIndex);
        return "you have now " + currentHp + " HP";
    }

    public String lookAround() {
        String s = "you can go ";
        if (!hashMap.get(currentPos).getW().equals("-1")) {
            s += "west ";
        }
        if (!hashMap.get(currentPos).getS().equals("-1")) {
            s += "south ";
        }
        if (!hashMap.get(currentPos).getN().equals("-1")) {
            s += "north ";
        }
        if (!hashMap.get(currentPos).getE().equals("-1")) {
            s += "east ";
        }
        return s;
    }

    public int bossAttack(Enemy enemy) {
        int damage = 0;
        int itemIndex = 0;
        for (Items i : backpack) {
            if (i.getTypeOfItem() == TypeOfItem.WEAPON) {
                Weapon w = (Weapon) i;
                damage = damage + i.effect();
                if (w.getDurability() == 0) {
                    backpack.remove(itemIndex);
                }
            }
        }
        return battleResults(enemy, damage);
    }

    public int battleResults(Enemy enemy, int damage) {
        int enemyHealth = enemy.getHealth() - damage;
        if (enemyHealth <= 0) {
            return 1;
        }
        int remainingHealth = health - enemy.getDamage();
        if (remainingHealth <= 0) {
            return -1;
        }
            setHealth(remainingHealth);
            enemy.setHealth(enemyHealth);
            return 0;
    }


    public int attack(int itemIndex, Enemy enemy) {
        int damage = backpack.get(itemIndex).effect();
        Weapon w = (Weapon) backpack.get(itemIndex);
        if (w.getDurability() == 0) {
            backpack.remove(itemIndex);
        }
        return battleResults(enemy, damage);
    }

    public String retreat() {
        if (!hashMap.get(currentPos).getW().equals("-1")) {
            return "you ran into " + hashMap.get(moveToWest());
        }
        if (!hashMap.get(currentPos).getS().equals("-1")) {
            return "you ran into " + hashMap.get(moveToSouth());
        }
        if (!hashMap.get(currentPos).getN().equals("-1")) {
            return "you ran into " + hashMap.get(moveToNorth());
        }
        if (!hashMap.get(currentPos).getE().equals("-1")) {
            return "you ran into " + hashMap.get(moveToEast());
        }
        return null;
    }

    public String inventory() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < backpack.size(); i++) {
            s.append(i + ") ").append(backpack.get(i)).append("\n");
        }
        return s.toString();
    }

    public ArrayList<Items> getBackpack() {
        return backpack;
    }
}
