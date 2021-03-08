package guleksi.redi.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player1, dirt, grass, stone, tree, luigi, kerpudha;

    // is going to load in everything for our game
    // and it's going to be called once
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player1 = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);

        luigi = sheet.crop(width, height, width, height);
        kerpudha = sheet.crop(width * 2, height, width, height);

    }


}
