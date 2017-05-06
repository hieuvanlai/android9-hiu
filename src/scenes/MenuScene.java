package scenes;

import game.GameWinDow;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by hieuv on 5/6/2017.
 */
public class MenuScene implements GameScene {


    public  void  keyPressed(KeyEvent keyEvent){


    }
    public  void  keyReleased(KeyEvent keyEvent){
        if (keyEvent.getKeyCode()==KeyEvent.VK_ENTER){
            GameWinDow.instance.setCurremtScene(new Level1Since(600,800));

        }


    }
    public  void  draw(Graphics graphics){



    }
    public void update(){

    }
}
