import sun.invoke.empty.Empty;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hieuv on 4/14/2017.
 */
public class Enemy {
    private int  EnemyX;
    private  int  EnemyY;
    private Image image;
    private int sizeMapX;
    private int sizeMapY;
    private  int kiemtrax;
    private boolean move;
    private int shotleft;

    private  ArrayList<Bullet> bullets;
    private int shotdelay;

    public Enemy( Image image, int sizeMapX, int sizeMapY) {
        move = true;
        bullets =new ArrayList<>();
        EnemyX = 0;
        EnemyY = 50;
        this.image = image;
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
        shotdelay=30;
        shotleft=1;
    }
    public void update(){
        if (move){
            EnemyX++;
            if (EnemyX==sizeMapX-32){
                move=false;
            }

        }else{
            EnemyX--;
            if (EnemyX<10){
                move=true;
            }
        }

        for (Bullet bullet1:bullets){
            bullet1.updatedown();
        }

    }

    public void  draw(Graphics graphics){
        graphics.drawImage(this.image,this.EnemyX,this.EnemyY,null);
        for (Bullet b: bullets){
            b.draw(graphics);
        }
    }

    public void Shot(){
        shotdelay--;

        if (shotdelay==0){
            shotleft++;


            Bullet bul = null;
            if (shotleft%2==0){

                try {
                    bul = new Bullet((EnemyX),EnemyY, ImageIO.read(new File("res/bullet-round.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    bul = new Bullet((EnemyX+30),EnemyY, ImageIO.read(new File("res/bullet-round.png")));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


                bullets.add(bul);

            shotdelay=30;
        }


    }

}
