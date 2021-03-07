package guleksi.redi.tilegame;

import guleksi.redi.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    // main part of game is gonna be in this class

    public Display display;
    public int width, height;
    public String title;

    // THREAD - IN OUR CASE
    // When we start our game with our constructor here,
    // our Launcher class it creates a big program for all the code to run
    // now, we want our Game class to run on its own mini program - and that's a thread
    // A thread is a mini program

    private boolean running = false;
    private Thread thread;

    // buffer is a hidden computer screen within the computer(idea), its memory
    private BufferStrategy bs; // a way for the computer to draw things to the screen, it uses buffers
    private Graphics g; // (object)

    // temp code
    // private BufferedImage testImage1;
    // private BufferedImage testImage2;

    // Game Constructor
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        // init display
        display = new Display(title, width, height);

        // Tests
        /*
        try {
            testImage1 = ImageLoader.resizeImage(ImageLoader.loadImage("/textures/test.jpg"), 180, 180);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testImage2 = ImageLoader.resizeImage(ImageLoader.loadImage("/textures/r65v5.jpg"), 180, 180);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }

    // Update
    private void tick() {

    }

    // Render (Draw) to the screen with canvas
    private void render() {
        bs = display.getCanvas().getBufferStrategy(); // prevents flickering - Buffer -> Buffer -> Actual Screen
        // if its the first time running our game BufferStrategy is empty
        if (bs == null) {
            // init BufferStrategy
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        // Graphics - g, allows us to draw things to the canvas
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0, 0, width, height);
        // Draw Here!

        // 1.image to be drawn 2. x - coordinate 3. y - coordinate 4. image observer - null
        // g.drawImage(testImage1, 20, 20, null);
        // g.drawImage(testImage2, 200, 20, null);

        // End Drawing!
        // We have to tell Java that we're done drawing
        bs.show();
        g.dispose(); // graphics get done properly
    }

    // when we implement Runnable
    public void run() {

        init();

        // Game loop (UPDATE, RENDER, REPEAT)
        while (running) {
            tick();
            render();
        }

        stop();

    }

    // Start Thread
    // synchronized - keyword used when working directly with threads
    public synchronized void start() {
        // safety check
        if (running) {
            return;
        }
        running = true;
        // we have to init thread
        // takes the class to run
        thread = new Thread(this); // this - this class Game class
        thread.start(); // starts thread, calls run() method
    }

    // Stop Thread
    public synchronized void stop() {
        // safety check
        if (!running) {
            return;
        }
        running = false;
        // close thread
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
