package guleksi.redi.tilegame.display;

import javax.swing.*;
import java.awt.*;

public class Display {

    // window JFrame (object)
    private JFrame frame;
    private Canvas canvas; // allows us to draw graphics into JFrame, get images into JFrame


    // title, width, height for JFrame
    private String title;
    private int width, height; // talking in pixels (little dots on computer screen that make up all the images)

    // Constructor
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    // we do JFrame init here so we dont shove everything inside of Display Constructor
    public void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        // makes sure that window closes down properly
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // optional
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // window appears center of the screen
        frame.setVisible(true); // we need to set this

        canvas = new Canvas();

        // canvas takes a new Dimension object with width and height
        canvas.setPreferredSize(new Dimension(width, height));
        // stays at width and height that we give it
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false); // !important

        // adding canvas to JFrame
        frame.add(canvas);
        // will resize our window a little bit that way we're able to see the canvas fully
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}
