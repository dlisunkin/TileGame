package dev.dlisunkin.tilegame;

import dev.dlisunkin.tilegame.display.Display;
import dev.dlisunkin.tilegame.gfx.Assets;
import dev.dlisunkin.tilegame.gfx.GameCamera;
import dev.dlisunkin.tilegame.gfx.ImageLoader;
import dev.dlisunkin.tilegame.gfx.SpriteSheet;
import dev.dlisunkin.tilegame.input.KeyManager;
import dev.dlisunkin.tilegame.states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;

    private boolean running;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;
    private State settingsState;

    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera  gameCamera;

    public Game(String title, int width, int height) {
        this.width  = width;
        this.height = height;
        this.title  = title;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(this,0,0);

        gameState   = new GameState(this);
        menuState   = new MenuState(this);
        settingsState = new SettingsState(this);
        StateManager.setState(gameState);
    }

    private void tick() {
        keyManager.tick();

        if(StateManager.getState() != null) {
            StateManager.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);                   //Clears everything under the selected Rectangle
        //Draw Here!

        if(StateManager.getState() != null) {
            StateManager.getState().render(g);
        }

        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
