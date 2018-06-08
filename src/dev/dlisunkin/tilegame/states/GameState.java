package dev.dlisunkin.tilegame.states;

import dev.dlisunkin.tilegame.Game;
import dev.dlisunkin.tilegame.entities.creatures.Player;
import dev.dlisunkin.tilegame.gfx.Assets;

import dev.dlisunkin.tilegame.tile.Tile;
import dev.dlisunkin.tilegame.worlds.World;
import java.awt.*;

public class GameState extends State{

    private Player player;
    private World  world;

    public GameState(Game game) {
        super(game);
        player = new Player(game,100, 100);
        world = new World("res/worlds/world1.txt");
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }

}
