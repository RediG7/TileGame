package guleksi.redi.tilegame.worlds;

import guleksi.redi.tilegame.Handler;
import guleksi.redi.tilegame.entities.EntityManager;
import guleksi.redi.tilegame.entities.creatures.Player;
import guleksi.redi.tilegame.entities.statics.Tree;
import guleksi.redi.tilegame.tiles.Tile;
import guleksi.redi.tilegame.utils.Utils;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height; // 5x5 -> 5tiles width, 5 tiles height
    private int spawnX, spawnY;
    private int[][] tiles;
    // Entities
    private EntityManager entityManager;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 250));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {
        // limit tile render to only visible tiles to user
        // if negative -> builds 0, if positive -> game.getGameCamera().getxOffset() / Tile.TILE_WIDTH
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH); // returns the bigger number between 2 values
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        // Entities
        entityManager.render(g);
    }

    public Tile getTile(int x, int y) {
        // to prevent errors
        if(x < 0 || y < 0 || x >+ width || y >= height) {
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        // id numbers of tiles
        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); // convert from 1D array to 2D array
            }
        }

        // testing
        /*
        width = 5;
        height = 5;
        tiles = new int[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = 1;
            }
        }
        */
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
