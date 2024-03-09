package commands;
import Mapa.*;
import player.*;
import java.io.IOException;


public abstract class Commands extends WorldMap {
    public String execute(Player player){
        return null;
    }
    public abstract boolean exit();
}
