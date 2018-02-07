package dev.dlisunkin.tilegame;

import dev.dlisunkin.tilegame.display.Display;
import dev.dlisunkin.tilegame.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImage;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
        testImage = ImageLoader.loadImage("/textures/8_bit_block.png");
    }

    private void tick() {

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

        g.drawImage(testImage, 20, 20, null);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        while(running) {
            tick();
            render();
        }

        stop();
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
