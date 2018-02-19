package dev.dlisunkin.tilegame.entities.creatures;

import dev.dlisunkin.tilegame.Game;
import dev.dlisunkin.tilegame.entities.Creature;
import dev.dlisunkin.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up) {
            yMove = -speed;
        }
        if(game.getKeyManager().down) {
            yMove = speed;
        }
        if(game.getKeyManager().left) {
            xMove = -speed;
        }
        if(game.getKeyManager().down) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.redDot, (int) x, (int) y, width, height, null);
    }
}
