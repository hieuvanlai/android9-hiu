package scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by hieuv on 5/6/2017.
 */
public interface GameScene {
    void  keyPressed(KeyEvent keyEvent);

    void  keyReleased(KeyEvent keyEvent);
    void  draw(Graphics graphics);
    void update();
}
