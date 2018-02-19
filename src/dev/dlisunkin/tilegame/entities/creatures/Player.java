package dev.dlisunkin.tilegame.entities.creatures;

import dev.dlisunkin.tilegame.entities.Creature;
import dev.dlisunkin.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.redDot, (int) x, (int) y, null);
    }
}
