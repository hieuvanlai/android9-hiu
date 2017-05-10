package Controllers;

import View.ImageRenderer;
import enemies.MoveBeHavior;
import game.Collider;
import game.Plane;
import models.GameRect;

import java.awt.*;

/**
 * Created by hieuv on 5/8/2017.
 */
public class PlaneLeverControler extends Controller implements Collider {
    MoveBeHavior moveBeHavior = new MoveBeHavior();

    public PlaneLeverControler(int x, int y, Image image) {
        int rectX = x- image.getWidth(null)/2;
        int rectY = y- image.getHeight(null);
        this.gameRect= new GameRect(rectX,rectY,image.getWidth(null),image.getHeight(null));
        this.imageRenderer = new ImageRenderer(image);
        CollisionManager.instance.add(this);

    }
    @Override
    public void update(){
        moveBeHavior.movebackgroud(gameRect);

    }



    @Override
    public void onCollider(Collider other) {

        if (other instanceof Plane){
            System.out.println("dkmfhkk");

            getGameRect().setDead(true);
            ((Plane)other).GetLever();
        }
    }
}
