package game;

import Controllers.CollisionManager;
import Controllers.Controller;
import View.ImageRenderer;
import enemies.EnemyController;
import models.GameRect;

import java.awt.*;

/**
 * Created by hieuv on 4/12/2017.
 */
public class BulletController  extends Controller implements Collider
{

    private  int damege = 1;


    public BulletController(int x, int y, Image image) {
        int rectX = x- image.getWidth(null)/2;
        int rectY = y- image.getHeight(null);
        this.gameRect= new GameRect(rectX,rectY,image.getWidth(null),image.getHeight(null));
        this.imageRenderer = new ImageRenderer(image);
        CollisionManager.instance.add(this);

    }





    public  void updateup(){
        gameRect.move(0,-15);
    }


    @Override
    public void onCollider(Collider other) {
        if (other instanceof EnemyController){
            ((EnemyController)other).GetHit(damege);
            getGameRect().setDead(true);

        }
    }
}
