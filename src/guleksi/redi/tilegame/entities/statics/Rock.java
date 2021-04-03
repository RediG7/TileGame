package guleksi.redi.tilegame.entities.statics;

import guleksi.redi.tilegame.Handler;
import guleksi.redi.tilegame.gfx.Assets;
import guleksi.redi.tilegame.tiles.Tile;
import guleksi.redi.tilegame.items.Item;

import java.awt.*;

public class Rock extends StaticEntity{

    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        // setting rock bounds for collision detection
        bounds.x = 3;
        bounds.y = (int) (height / 2f);
        bounds.width = width - 6;
        bounds.height = (int) (height - height / 2f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
