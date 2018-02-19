package dev.dlisunkin.tilegame.states;

import dev.dlisunkin.tilegame.Game;

import java.awt.Graphics;

public abstract class State {

    protected Game game;

    public State (Game game) {
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
