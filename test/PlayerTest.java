package test;
import Mapa.WorldMap;
import player.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class PlayerTest {
    PlayerControls pc;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        WorldMap wm = new WorldMap();
        try {
            Player p = new Player(wm.load());
            pc = new PlayerControls(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @org.junit.jupiter.api.Test
    void moveToNorth() {
        assertEquals(pc.move("n"),"you hit a wall");

    }

    @org.junit.jupiter.api.Test
    void moveToSouth() {
    }

    @org.junit.jupiter.api.Test
    void moveToEast() {
    }

    @org.junit.jupiter.api.Test
    void moveToWest() {
    }

    @org.junit.jupiter.api.Test
    void attack() {
    }
}