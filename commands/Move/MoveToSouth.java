package commands.Move;
import commands.*;
import player.Player;

public class MoveToSouth extends Commands{
    @Override
    public String execute(Player player) {
        return player.moveToSouth(); // maybe add welcome here
    }

    @Override
    public boolean exit() {
        return false;
    }
}
