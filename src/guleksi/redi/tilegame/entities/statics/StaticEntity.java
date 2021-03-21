package guleksi.redi.tilegame.entities.statics;

import guleksi.redi.tilegame.Handler;
import guleksi.redi.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

}
