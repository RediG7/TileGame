package guleksi.redi.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player1, player2, player3, blueColor, mario, luigi, kerpudha, fighter, alien, princess, wizard, draco, sonic, bescamel, black, violet;

    // is going to load in everything for our game
    // and it's going to be called once
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet1.jpg"));

        player1 = sheet.crop(0, 0, width, height);
        player2 = sheet.crop(width, 0, width, height);
        player3 = sheet.crop(width * 2, 0, width, height);
        blueColor = sheet.crop(width * 3, 0, width, height);
        mario = sheet.crop(0, height, width, height);
        luigi = sheet.crop(width, height, width, height);
        kerpudha = sheet.crop(width * 2, height, width, height);
        fighter = sheet.crop(width * 3, height, width, height);
        alien = sheet.crop(0, height * 2, width, height);
        princess = sheet.crop(width, height * 2, width, height);
        wizard = sheet.crop(width * 2, height * 2, width, height);
        draco = sheet.crop(width * 3, height * 2, width, height);
        sonic = sheet.crop(0, height * 3, width, height);
    }


}
