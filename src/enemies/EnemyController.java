package enemies;

import View.ImageRenderer;
import models.GameRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



/**
 * Created by hieuv on 4/15/2017.
 */
public class EnemyController {
    private GameRect gameRect;
    private ImageRenderer imageRenderer;


    private int sizeMapX;
    private int sizeMapY;
    private  int kiemtrax;
    private boolean move;
    private int shotleft;

    private ArrayList<EnemyBullet> bullets;
    private int shotdelay;

    public EnemyController( Image image, int sizeMapX, int sizeMapY) {
        move = true;
        bullets =new ArrayList<>();
        gameRect = new GameRect(0,50,50,50);

        imageRenderer = new ImageRenderer(image);
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
        shotdelay=30;
        shotleft=1;
    }
    public void update(){
        if (move){
            gameRect.setX(gameRect.getX()+1);
            if (gameRect.getX()==sizeMapX-32){
                move=false;
            }

        }else{
            gameRect.setX(gameRect.getX()-1);
            if (gameRect.getX()<10){
                move=true;
            }
        }

        for (EnemyBullet bullet1:bullets){
            bullet1.updatedown();
        }

    }

    public void  draw(Graphics graphics){
        imageRenderer.render(graphics,gameRect);
        for (EnemyBullet b: bullets){
            b.draw(graphics);
        }
    }

    public void Shot(){
        shotdelay--;

        if (shotdelay==0){
            shotleft++;


            EnemyBullet bul = null;
            if (shotleft%2==0){

                try {
                    bul = new EnemyBullet((gameRect.getX()),gameRect.getY(), ImageIO.read(new File("res/bullet-round.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    bul = new EnemyBullet((gameRect.getX()+30),gameRect.getY(), ImageIO.read(new File("res/bullet-round.png")));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            bullets.add(bul);

            shotdelay=30;
        }


    }

}
