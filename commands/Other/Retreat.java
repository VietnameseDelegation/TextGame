package commands.Other;

import commands.Commands;
import player.Player;

public class Retreat extends Commands {
    @Override
    public String execute(Player player){
        return player.retreat();
    }
    @Override
    public boolean exit() {
        return false;
    }
}
