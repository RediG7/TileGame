package guleksi.redi.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis(); // this is going to get the miliseconds that have passed since the start of our program
    }

    public void tick() {
        timer += System.currentTimeMillis() - lastTime; // gets the time between the tick methods
        lastTime = System.currentTimeMillis(); // now reset lastTime

        if (timer > speed) {
            index ++;
            timer = 0;
            if (index >= frames.length) // 2
                index = 0;

        // we have to frames so we reset index to 0 if it is >= 2
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }

}
