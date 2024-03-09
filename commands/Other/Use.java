package commands.Other;

import commands.Commands;
import player.Player;

public class Use extends Commands {
    public String execute(Player player,int index) {
        return player.use(index);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
