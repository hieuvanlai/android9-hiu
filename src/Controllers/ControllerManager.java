package Controllers;

import game.Collider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hieuv on 5/5/2017.
 */
public class ControllerManager {
   private ArrayList<Controller> list;
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
            if (controller.gameRect.getY()>=800){
                controllerIterator.remove();
            }
        }
        for (Controller controller: list){
            controller.update();

        }
    }
    public  void  draw(Graphics graphics){
        for (Controller controller: list){
            controller.draw(graphics);
        }
    }
    public  void  add(Controller controller){
        list.add(controller);
    }
    public  void Shot(){
        for (Controller controller: list){
            controller.Shot();

        }

    }

}
