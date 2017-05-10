package enemies;

import Controllers.*;
import View.Animation;
import View.ImageRenderer;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import game.Collider;
import models.GameRect;
import utils.Utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    private int shotdelay =0;
    public boolean isPlanelever = false;



    private int x = 1;
    private Animation animation;
    ArrayList<Image> images;

    public void setMoveBeHavior(int x) {
        this.x=x;
    }



    public EnemyController( int sizeMapX, int sizeMapY,ArrayList<Image> images) {
//        imageRenderer = new ImageRenderer("res/enemy_plane_white_1.png");

        gameRect= new GameRect(Utils.random.nextInt(sizeMapX),50,50,50);
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
        CollisionManager.instance.add(this);
        getGameRect().setHit(3);
        shotdelay = 50;
        animation = new Animation(images);



    }
    @Override
    public void draw(Graphics graphics){
        animation.draw(graphics,gameRect);

    }
    public void update(){
        shotdelay--;

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


//
    }


    @Override
    public void onCollider(Collider other) {


    }

    public void  GetHit(int damage){
      gameRect.setHit(getGameRect().getHit()-damage);
        if (getGameRect().getHit()<=0){
            getGameRect().setDead(true);
            GameRect  rect = new GameRect(getGameRect().getX(),getGameRect().getY(),0,0);
            try {
                Utils.playSound("res/Explosion12.wav",false);
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            if (isPlanelever) {
                PlaneLeverControler planeLeverControler = new PlaneLeverControler(rect.getX(),rect.getY(),Utils.loadImage("res/PlaneLV.png"));
                ControllerManager.instance.add(planeLeverControler);


            }
            ExplosionController explosionController = new ExplosionController(rect);
            ControllerManager.instance.add(explosionController);

        }

    }
    @Override
    public  void  Shot(){

        if (shotdelay==1){
            EnemyBullet enemyBullet = new EnemyBullet(getGameRect().getX(),gameRect.getY(),Utils.loadImage("res/bullet-round.png"));
            ControllerManager.instance.addbuletenymi(enemyBullet);
            shotdelay=50;
        }


    }
}
