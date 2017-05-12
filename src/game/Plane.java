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
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hieuv on 4/12/2017.
 */
 public class Plane extends Controller implements Collider{

    private int sizeMapX;
    private int sizeMapY;
    private int lever =0;

    public GameRect getGameRect() {
        return gameRect;
    }

    @Override
    public void onCollider(Collider other) {

    }
    @Override
    public void draw(Graphics graphics){
        graphics.drawImage(Utils.xoayanh(Utils.loadImage("res/Untitled-5.png")),gameRect.getX(),gameRect.getY(),null);



    }
    public void  GetHit(int damage){
        gameRect.setHit(getGameRect().getHit()-damage);

        if (getGameRect().getHit()<=0){

            getGameRect().setDead(true);
        }

    }
    public void  GetLever(){
        lever++;


        if (lever==4){
            this.imageRenderer = new ImageRenderer("res/plane2.png");
            try {
                Utils.playSound("res/Jump6.wav",false);
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        }
        if (lever==8){
            this.imageRenderer = new ImageRenderer("res/plane4.png");
            try {
                Utils.playSound("res/Jump6.wav",false);
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
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
    public  void  Shot() throws UnsupportedAudioFileException {
        if (shotdelay==1){
            if (lever==0){
                BulletController enemyBullet = new BulletController(getGameRect().getX()+40,getGameRect().getY(), Utils.loadImage("res/bullet.png"));
                ControllerManager.instance.add(enemyBullet);
            }
            if (lever==4){
                BulletController enemyBullet = new BulletController(getGameRect().getX()+60,getGameRect().getY(), Utils.loadImage("res/bullet.png"));
                BulletController enemyBulle1 = new BulletController(getGameRect().getX()+20,getGameRect().getY(), Utils.loadImage("res/bullet.png"));
                ControllerManager.instance.add(enemyBullet);
                ControllerManager.instance.add(enemyBulle1);

            }
            System.out.println(lever);
            if (lever>=8){
                BulletController enemyBullet = new BulletController(getGameRect().getX()+60,getGameRect().getY(), Utils.loadImage("res/bullet.png"),true);
                BulletController enemyBulle1 = new BulletController(getGameRect().getX()+20,getGameRect().getY(), Utils.loadImage("res/bullet.png"),true,false);
                BulletController enemyBulle2 = new BulletController(getGameRect().getX()+40,getGameRect().getY(), Utils.loadImage("res/bullet.png"));
                ControllerManager.instance.add(enemyBullet);
                ControllerManager.instance.add(enemyBulle1);
                ControllerManager.instance.add(enemyBulle2);

            }


            shotdelay=10;
            Utils.playSound("res/Hit_Hurt12.wav",false);


        }

    }



    public  void update(){
        shotdelay--;
       gameRect.move(dx,dy);


    }



}
