package guleksi.redi.tilegame.entities;

import guleksi.redi.tilegame.Handler;
import guleksi.redi.tilegame.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            // render from top to bottom based on Y coordinate, but we need
            // to check the bottom y-coordinate of the entities ( y coordinate + height )
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1; // a should be rendered before b
            return 1; // a should be rendered after b (if a.getY() > b.getY())
        }
    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g) {
        for (Entity e: entities) { // short loop of the loop above
            e.render(g);
        }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    // GETTERS SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
