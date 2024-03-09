package commands.Move;
import commands.*;
import player.Player;

public class MoveToEast extends Commands{
    @Override
    public String execute(Player player) {

        return player.moveToEast();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
