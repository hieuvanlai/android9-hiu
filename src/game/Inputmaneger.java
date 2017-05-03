package game;

import java.awt.event.KeyEvent;

/**
 * Created by hieuv on 4/14/2017.
 */
public class Inputmaneger {
    boolean isAPressed;
    boolean isDPressed;
    boolean isWPressed;
    boolean isSPressed;
    boolean isENTERPressed;
    public void  keyPressed(KeyEvent keyEvent){
        if (keyEvent.getKeyCode()== KeyEvent.VK_A ){
            isAPressed=true;
        }
        if (keyEvent.getKeyCode()== KeyEvent.VK_W ){
           isWPressed=true;
        }
        if (keyEvent.getKeyCode()== KeyEvent.VK_D ){
           isDPressed=true;
        }
        if (keyEvent.getKeyCode()== KeyEvent.VK_S ){
            isSPressed=true;
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_ENTER){
            isENTERPressed=true;
        }


    }
    public void  keyReleased(KeyEvent keyEvent){
        if (keyEvent.getKeyCode()== KeyEvent.VK_A ){
            isAPressed=false;
        }
        if (keyEvent.getKeyCode()== KeyEvent.VK_W ){
            isWPressed=false;
        }
        if (keyEvent.getKeyCode()== KeyEvent.VK_D ){
            isDPressed=false;
        }
        if (keyEvent.getKeyCode()== KeyEvent.VK_S ){
            isSPressed=false;
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_ENTER){
            isENTERPressed=false;
        }


    }

}
