package Controllers;

import Controllers.CollisionManager;
import Controllers.Controller;
import View.ImageRenderer;
import enemies.EnemyController;
import game.Collider;
import models.GameRect;

import java.awt.*;

/**
 * Created by hieuv on 4/12/2017.
 */
public class BulletController  extends Controller implements Collider
{

    private  int damege = 1;
    private boolean isbulletright;
    private boolean isbulletleft;


    public BulletController(int x, int y, Image image) {
        int rectX = x- image.getWidth(null)/2;
        int rectY = y- image.getHeight(null);
        this.gameRect= new GameRect(rectX,rectY,image.getWidth(null),image.getHeight(null));
        this.imageRenderer = new ImageRenderer(image);
        CollisionManager.instance.add(this);

    }
    public BulletController(int x, int y, Image image,boolean isbulletright) {
        int rectX = x- image.getWidth(null)/2;
        int rectY = y- image.getHeight(null);
        this.gameRect= new GameRect(rectX,rectY,image.getWidth(null),image.getHeight(null));
        this.imageRenderer = new ImageRenderer(image);
        this.isbulletright = isbulletright;
        CollisionManager.instance.add(this);


    }
    public BulletController(int x, int y, Image image,boolean isbulletleft,boolean isbulletright) {
        int rectX = x- image.getWidth(null)/2;
        int rectY = y- image.getHeight(null);
        this.gameRect= new GameRect(rectX,rectY,image.getWidth(null),image.getHeight(null));
        this.imageRenderer = new ImageRenderer(image);
        this.isbulletleft = isbulletleft;
        CollisionManager.instance.add(this);


    }

    @Override
    public void Shot(){
    }





    public  void update(){
        if (isbulletleft){
            gameRect.move(-5,-15);
        }else {
            if (isbulletright){
                gameRect.move(+5,-15);
            }else {
                gameRect.move(0,-15);
            }
        }


        if (gameRect.getY()<=0){
            getGameRect().setDead(true);
        }
    }


    @Override
    public void onCollider(Collider other) {
        if (other instanceof EnemyController){
            ((EnemyController)other).GetHit(damege);
            getGameRect().setDead(true);

        }
    }
}
