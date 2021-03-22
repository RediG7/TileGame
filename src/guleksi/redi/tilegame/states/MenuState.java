package guleksi.redi.tilegame.states;

import guleksi.redi.tilegame.Handler;
import guleksi.redi.tilegame.gfx.Assets;
import guleksi.redi.tilegame.ui.ClickListener;
import guleksi.redi.tilegame.ui.UIImageButton;
import guleksi.redi.tilegame.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null); // dont forget
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
