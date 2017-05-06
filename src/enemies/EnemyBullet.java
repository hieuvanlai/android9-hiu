package enemies;

import Controllers.CollisionManager;
import Controllers.Controller;
import Controllers.ControllerManager;
import View.ImageRenderer;
import game.Collider;
import game.Plane;
import models.GameRect;

import java.awt.*;

/**
 * Created by hieuv on 4/15/2017.
 */
public class EnemyBullet extends Controller implements Collider {
    private  int damege =1;


    public EnemyBullet(int x, int y, Image image) {
        int rectX = x- image.getWidth(null)/2;
        int rectY = y- image.getHeight(null);
        this.gameRect= new GameRect(rectX,rectY,image.getWidth(null),image.getHeight(null));
        this.imageRenderer = new ImageRenderer(image);
        CollisionManager.instance.add(this);

    }




    public  void update(){
            gameRect.move(0,+5);
    }

    @Override
    public void onCollider(Collider other) {
        if (other instanceof Plane){
            ((Plane)other).GetHit(damege);
            getGameRect().setDead(true);

        }
    }
    @Override
    public void Shot(){
    }

}
