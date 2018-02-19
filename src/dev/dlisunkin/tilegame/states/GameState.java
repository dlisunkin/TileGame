package dev.dlisunkin.tilegame.states;

import dev.dlisunkin.tilegame.gfx.Assets;

import java.awt.*;

public class GameState extends State{

    public GameState() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.whiteDot, 0, 0, null);
    }
}
