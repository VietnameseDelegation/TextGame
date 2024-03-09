package commands.Move;
import commands.*;
import player.Player;

public class MoveToWest extends Commands{
    private Player player;
    @Override
    public String execute(Player player) {
        return player.moveToWest();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
