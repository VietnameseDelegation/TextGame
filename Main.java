import java.io.IOException;
import player.*;
import Mapa.*;
public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        Player p;
        try {
             p = new Player(wm.load());
        } catch (IOException e) {
            System.out.println("file not found");
            throw new RuntimeException(e);
        }
        PlayerControls pc = new PlayerControls(p);
        pc.start();
    }
}