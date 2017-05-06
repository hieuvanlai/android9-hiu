package game;

import Controllers.BulletController;
import Controllers.CollisionManager;
import Controllers.Controller;
import Controllers.ControllerManager;
import View.ImageRenderer;
import enemies.EnemyBullet;
import models.GameRect;
import utils.Utils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hieuv on 4/12/2017.
 */
 public class Plane extends Controller implements Collider{

    private int sizeMapX;
    private int sizeMapY;

    public GameRect getGameRect() {
        return gameRect;
    }

    @Override
    public void onCollider(Collider other) {

    }
    public void  GetHit(int damage){
        gameRect.setHit(getGameRect().getHit()-damage);
        System.out.println(getGameRect().getHit());
        if (getGameRect().getHit()<=0){

            getGameRect().setDead(true);
        }

    }

    int dy;
    int dx;
    int shotdelay;

    public Plane(int x, int y, Image image,int sizeMapX,int sizeMapY) {

        this.sizeMapX= sizeMapX;
        this.sizeMapY= sizeMapY;
        this.gameRect= new GameRect(x,y,70,70);
        this.imageRenderer = new ImageRenderer(image);
        gameRect.setHit(20);
        CollisionManager.instance.add(this);
        shotdelay=10;

    }

    public void move(Inputmaneger inputmaneger){
        dx=0;
        dy=0;
        if (inputmaneger.isAPressed && gameRect.getX()+dx>=0) dx -=4;
        if (inputmaneger.isDPressed &&  gameRect.getX()+dx<=sizeMapX-60 ) dx +=4;
        if (inputmaneger.isWPressed &&  gameRect.getY()+dy>=30 ) dy -=4;
        if (inputmaneger.isSPressed && gameRect.getY()+dy<=sizeMapY-50 ) dy +=4;


    }
    public  void  Shot(){
        if (shotdelay==1){

            BulletController enemyBullet = new BulletController(getGameRect().getX()+40,getGameRect().getY(), Utils.loadImage("res/bullet.png"));
            ControllerManager.instance.add(enemyBullet);
            shotdelay=10;


        }

    }



    public  void update(){
        shotdelay--;
       gameRect.move(dx,dy);

    }



}
