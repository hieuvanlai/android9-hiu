import View.ImageRenderer;
import models.GameRect;

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
 public class Plane {
    private GameRect gameRect;
    private ImageRenderer imageReader;
    private int sizeMapX;
    private int sizeMapY;

    public GameRect getGameRect() {
        return gameRect;
    }

    int dy;
    int dx;
    int shotdelay;

    public Plane(int x, int y, Image image,int sizeMapX,int sizeMapY) {
        gameRect = new GameRect(x,y,70,70);
        imageReader = new ImageRenderer(image);
        this.sizeMapX= sizeMapX;
        this.sizeMapY= sizeMapY;

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
    public void Shot(Inputmaneger inputmaneger){



    }







    public void  draw(Graphics graphics){
        graphics.drawImage(imageReader.getImage(),gameRect.getX(),gameRect.getY(),null);

    }

    public  void update(){
       gameRect.move(dx,dy);

    }



}
