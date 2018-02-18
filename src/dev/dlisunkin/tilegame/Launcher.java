package dev.dlisunkin.tilegame;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Tile Game", 500, 500);

        game.start();
    }

}