package test;

import Mapa.WorldMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;
import player.PlayerControls;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerControlsTest {
    PlayerControls pc;
    @BeforeEach
    void setUp() {
        WorldMap wm = new WorldMap();
        try {
            Player p = new Player(wm.load());
            pc = new PlayerControls(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void move() {
    }

    @Test
    void action() {
    }

    @Test
    void start() {

    }
}