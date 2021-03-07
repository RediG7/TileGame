package guleksi.redi.states;

import guleksi.redi.gfx.Assets;

import java.awt.*;

public class GameState extends State{

    public GameState() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.luigi, 0, 0, null);
    }
}
