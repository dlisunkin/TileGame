package dev.dlisunkin.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage redDot, whiteDot, blackDot, blueTile, greenTile;
    public static BufferedImage player, dirt, grass, stone, tree;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Spreadsheet.png"));

        blackDot    = sheet.crop(0,0, width, height);
        redDot      = sheet.crop(width * 1, 0, width, height);
        blueTile    = sheet.crop(width * 2, 0, width, height);
        greenTile   = sheet.crop(width * 3, 0, width, height);
        whiteDot    = sheet.crop(0, height * 1, width, height);

        SpriteSheet tempsheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player  = tempsheet.crop(0, 0, width, height);
        dirt    = tempsheet.crop(width * 1, 0, width, height);
        grass   = tempsheet.crop(width * 2, 0, width, height);
        stone   = tempsheet.crop(width * 3, 0, width, height);
        tree    = tempsheet.crop(0, height * 1, width, height);
    }

}
