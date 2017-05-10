package Controllers;

import game.Collider;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hieuv on 5/5/2017.
 */
public class ControllerManager {
   private ArrayList<Controller> list;
   public  ArrayList<Controller> newlist = new ArrayList<>();

   public  static  final ControllerManager instance = new ControllerManager();

    public ControllerManager() {
        list = new ArrayList<>();
    }
    public void update(){
        Iterator<Controller> controllerIterator = list.iterator();
        while (controllerIterator.hasNext())
        {
            Controller controller = controllerIterator.next();
            if (controller.getGameRect().isDead()){
                controllerIterator.remove();
                CollisionManager.instance.remove((Collider) controller);


            }
            if (controller.gameRect.getY()>=900){
                controllerIterator.remove();
                CollisionManager.instance.remove((Collider) controller);

            }
        }
        for (Controller controller: list){
            controller.update();

        }
        for (Controller controller: newlist){
            list.add(controller);

        }
        newlist.clear();
    }
    public  void  draw(Graphics graphics){
        for (Controller controller: list){
            controller.draw(graphics);
        }
    }
    public  void  add(Controller controller){
        list.add(controller);
    }
    public  void  addbuletenymi(Controller controller){
        newlist.add(controller);
    }
    public  void Shot(){
        for (Controller controller: list){
            try {
                controller.Shot();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }

        }

    }

}
