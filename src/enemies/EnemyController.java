package enemies;

import Controllers.BulletController;
import Controllers.CollisionManager;
import Controllers.Controller;
import Controllers.ControllerManager;
import View.ImageRenderer;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import game.Collider;
import models.GameRect;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by hieuv on 4/15/2017.
 */
public class EnemyController extends Controller implements Collider {

    private MoveBeHavior moveBeHavior = new MoveBeHavior();


    private int sizeMapX;
    private int sizeMapY;
    private int shotdelay;



    private int x = 1;
    public void setMoveBeHavior(int x) {
        this.x=x;
    }



    public EnemyController(Image image, int sizeMapX, int sizeMapY) {

        super(new GameRect(Utils.random.nextInt(sizeMapX),50,50,50), new ImageRenderer(image));
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
        CollisionManager.instance.add(this);
        getGameRect().setHit(3);
        shotdelay = 30;


    }
    public void update(){
        if (x==1){
            moveBeHavior.move(gameRect);
        }
        if (x==2){
            moveBeHavior.moveleft(gameRect);
        }
        if (x==3){
            moveBeHavior.moveright(gameRect);
        }
        if (gameRect.getX()==sizeMapX){
            this.x=2;
        }
        if (gameRect.getX()==0){
            this.x=3;
        }
        shotdelay--;

//
    }


    @Override
    public void onCollider(Collider other) {


    }

    public void  GetHit(int damage){
      gameRect.setHit(getGameRect().getHit()-damage);
        if (getGameRect().getHit()<=0){
            getGameRect().setDead(true);
        }

    }
    @Override
    public  void  Shot(){
//        EnemyBullet enemyBullet = new EnemyBullet(getGameRect().getX(),gameRect.getY(),Utils.loadImage("res/bullet.png"));
    }
}
