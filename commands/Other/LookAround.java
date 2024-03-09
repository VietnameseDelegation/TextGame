package commands.Other;

import commands.Commands;
import player.Player;

public class LookAround extends Commands {
    @Override
    public String execute(Player player) {
        return player.lookAround();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
