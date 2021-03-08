package guleksi.redi.tilegame.states;

import guleksi.redi.tilegame.Game;

import java.awt.*;

public abstract class State {

    // *************************************
    // can be done in a separate class
    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }
    // *************************************


    // CLASS

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}