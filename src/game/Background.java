package game;

import Controllers.Controller;
import View.ImageRenderer;
import enemies.MoveBeHavior;
import models.GameRect;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hieuv on 5/6/2017.
 */
public class Background extends Controller {
    Image backgroundImage;
    MoveBeHavior moveBeHavior = new MoveBeHavior();
    private boolean isImagelast;


    public Background(String s,boolean  isImagelast) {
        backgroundImage = Utils.loadImage(s);
        int y = 0;
        if (isImagelast){
            y=-800;
        }
        gameRect = new GameRect(0,y,600,800);
        this.imageRenderer = new ImageRenderer(backgroundImage);



    }

    @Override
    public void update(){
        if (isImagelast){
            System.out.println("dkm");
            if (gameRect.getY()>=800){
                gameRect.setY(0);

            }

        }
        else {

            if (gameRect.getY()>=800){
                gameRect.setY(-800);
            }
        }
        moveBeHavior.movebackgroud(gameRect);




    }
}
