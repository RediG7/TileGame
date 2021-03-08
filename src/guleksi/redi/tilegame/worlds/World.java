package guleksi.redi.tilegame.worlds;

import guleksi.redi.tilegame.Game;
import guleksi.redi.tilegame.tiles.Tile;
import guleksi.redi.tilegame.utils.Utils;

import java.awt.*;

public class World {

    private Game game;
    private int width, height; // 5x5 -> 5tiles width, 5 tiles height
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(Game game, String path) {
        this.game = game;
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        // limit tile render to only visible tiles to user
        // if negative -> builds 0, if positive -> game.getGameCamera().getxOffset() / Tile.TILE_WIDTH
        int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILE_WIDTH); // returns the bigger number between 2 values
        int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
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

}
