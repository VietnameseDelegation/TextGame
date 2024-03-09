package commands.Move;
import commands.*;
import player.Player;

public class MoveToNorth extends Commands {
    @Override
    public String execute(Player player) {
        return player.moveToNorth();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
