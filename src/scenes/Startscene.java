package scenes;

import game.Background;
import game.GameWinDow;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by hieuv on 5/6/2017.
 */
public class Startscene implements GameScene {
    Background background;
    Image start;


    public Startscene() {
        background = new Background("res/1945-logo.jpg",false);
        try {
            start = ImageIO.read(new File("res/startbutton.png"));

        } catch (IOException e) {


            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode()==KeyEvent.VK_ENTER){
            GameWinDow.instance.setCurremtScene(new Level1Since(600,800));

        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void draw(Graphics graphics) {
        background.draw(graphics);
        graphics.drawImage(start,180,600,null);

    }

    @Override
    public void update() {

    }
}
