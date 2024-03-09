package commands.Other;
import commands.Commands;
import player.*;
import NPC.*;

public class Attack extends Commands {
    public int execute(Player player,int itemIndex,Enemy enemy,boolean boss) {
        if (boss){return player.bossAttack(enemy);}
        return player.attack(itemIndex,enemy);
    }
    @Override
    public boolean exit() {
        return false;
    }
}
