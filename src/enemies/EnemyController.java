package enemies;

import View.ImageRenderer;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import models.GameRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by hieuv on 4/15/2017.
 */
public class EnemyController {
    private GameRect gameRect;
    private ImageRenderer imageRenderer;
    private MoveBeHavior moveBeHavior;


    private int sizeMapX;
    private int sizeMapY;
    private  int kiemtrax;
    private boolean move;
    private int shotleft;


    private int shotdelay;
    private int x;
    public void setMoveBeHavior(int x) {
        this.x=x;
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public EnemyController(Image image, int sizeMapX, int sizeMapY) {
        moveBeHavior = new MoveBeHavior();
        move = true;

        Random random = new Random();
        gameRect = new GameRect(random.nextInt(sizeMapX),50,50,50);

        imageRenderer = new ImageRenderer(image);
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
        shotdelay=30;
        shotleft=1;
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

//

    }

    public void  draw(Graphics graphics){
        imageRenderer.render(graphics,gameRect);
//
    }



}
