package guleksi.redi.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage dirt, grass, stone, tree;
    public static BufferedImage[] player_still, player_down, player_up, player_left, player_right;

    // is going to load in everything for our game
    // and it's going to be called once
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet2.png"));

        player_still = new BufferedImage[1];
        player_down = new BufferedImage[2]; // 2 because its a 2 frame animation
        player_up = new BufferedImage[2];
        player_right = new BufferedImage[2];
        player_left = new BufferedImage[2];

        player_still[0] = sheet2.crop(width * 4, 0 ,width, height);
        player_down[0] = sheet.crop(width * 4, 0, width, height); // first image of this animation
        player_down[1] = sheet.crop(width * 5, 0, width, height);
        player_up[0] = sheet.crop(width * 6, 0, width, height);
        player_up[1] = sheet.crop(width * 7, 0, width, height);
        player_right[0] = sheet.crop(width * 4, height, width, height);
        player_right[1] = sheet.crop(width * 5, height, width, height);
        player_left[0] = sheet.crop(width * 6, height, width, height);
        player_left[1] = sheet.crop(width * 7, height, width, height);


        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, 0, width, height);

    }


}
