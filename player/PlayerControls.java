package player;
import Items.*;
import Mapa.Room;
import NPC.Enemy;
import commands.Move.*;
import commands.Other.*;
import java.util.Random;
import java.util.Scanner;
public class PlayerControls {
    private final Player player;
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    boolean isAlive;
    public PlayerControls(Player player) {
        this.player = player;
    }
    public String move(String direction) {
        switch (direction) {
            case "n":
                return player.getHashMap().get(new MoveToNorth().execute(player)).toString();
            case "s":
                return player.getHashMap().get(new MoveToSouth().execute(player)).toString();
            case "e":
                return player.getHashMap().get(new MoveToEast().execute(player)).toString();
            case "w":
                return player.getHashMap().get(new MoveToWest().execute(player)).toString();
            case "l":
                return new LookAround().execute(player);
            case"u","i": return player.inventory();
        }
        return "invalid argument";
    }
    public String action(String action, int index, Enemy enemy,boolean boss) {

        switch (action) {
            case "a":
                int battleResult = new Attack().execute(player, index, enemy,boss);
                if (battleResult==1) {
                    return "you killed him";
                } else if(battleResult==0){
                    return "ouch you have:" + player.getHealth() + " HP left and enemy has " + enemy.getHealth() + " left";
                }else if (battleResult==-1){
                    return "better luck next time";
                }
            case "r":  enemy.damage(player); return new Retreat().execute(player) +" and got hit " + player.getHealth() +" HP left";
        }
        return "invalid argument";
    }
    public void start() {
        boolean lootAvalaible = false;
        int weaponDamage = rd.nextInt(9)+1;
       isAlive =true;
        boolean boss = false;
        player.addToBackpack(new Items().createLoot(1,weaponDamage));
        player.addToBackpack(new Items().createLoot(0,weaponDamage));
        while (isAlive) {
            Room room = player.getHashMap().get(player.getCurrentPos());
            // Weapon w = new Weapon(99,99, TypeOfItem.WEAPON);
            // Food f = new Food("steak",6,TypeOfItem.FOOD);
            int rng = room.getEvent();
            if((lootAvalaible||rng == 2||rng ==3)&& room.hasOccuredEvent()){
                lootAvalaible = loot(room,weaponDamage);
                weaponDamage = rd.nextInt(5)+1;
            }
            if (((rng == 1||rng == 4) && room.hasOccuredEvent())||rng == 9) {
                Enemy enemy = new Enemy();
                if (rng == 9){
                    enemy = new Enemy(true);
                }
                while(true) {
                    toPrint(enemy.toString());
                    toPrint("'a' - Attack 'r'- Retreat (you panic and run into a direction that you CANT choose)");
                    String s = sc.next();
                    int itemIndex=0;
                    if (s.equals("a")){
                        if (rng == 9){
                            boss = true;
                        }else{
                            toPrint("what item to use");
                    toPrint(player.inventory());
                        while(true) {
                            try {
                                Scanner scanner = new Scanner(System.in);
                                itemIndex=scanner.nextInt();
                                Weapon w = (Weapon) player.getBackpack().get(itemIndex);
                                break;
                            } catch (ClassCastException e){
                                enemy.damage(player);
                                toPrint(player.use(itemIndex));
                                if (player.battleResults(enemy,0)==-1){
                                    isAlive=false;
                                }
                            }
                            catch (Exception e) {
                                toPrint("invalid argument");
                            }
                        }
                    }
                    }
                    String battleStatus = action(s, itemIndex, enemy,boss);
                    toPrint(battleStatus);
                    if (battleStatus.contains("you ran")){
                        if (player.battleResults(enemy,0)==-1){
                            isAlive=false;
                        }
                        break;
                    }
                    if (battleStatus.equals("you killed him")){
                        lootAvalaible = true;
                        weaponDamage = enemy.getDamage();
                        room.setEventOccured(false);
                        break;
                    } else if (battleStatus.equals("better luck next time")) {
                       isAlive=false;
                       break;
                    }
                }
            }
            if (!isAlive){break;}
            if (isAlive&&boss){toPrint("YOU WIN HOORAY!!!!111!!"); break;}
            toPrint("move n - north s - south e - east w - west i - inventory, u - use l - look around" );
            String playerInput = sc.next();
            toPrint(move(playerInput));
            if (playerInput.equals("u")){
                while(true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        int userInput = scanner.nextInt();
                       new Use().execute(player,userInput);
                       break;
                    }
                    catch (Exception e) {
                        System.out.println("invalid argument");
                    }
                }
        }
        }
    }
    public boolean loot(Room room, int weaponDamage){
        player.addToBackpack(new Items().createLoot(rd.nextInt(2),weaponDamage));
        toPrint("you found " + player.getBackpack().get(player.getBackpack().size()-1));
        room.setEventOccured(false);
        return false;
    }
    public void toPrint(String toPrint) {
        System.out.println(toPrint);
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
