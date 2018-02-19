package dev.dlisunkin.tilegame.states;

import dev.dlisunkin.tilegame.entities.creatures.Player;
import dev.dlisunkin.tilegame.gfx.Assets;

import java.awt.*;

public class GameState extends State{

    private Player player;

    public GameState() {
        player = new Player(100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}