package Controllers;

import View.Animation;
import game.Collider;
import models.GameRect;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hieuv on 5/7/2017.
 */
public class ExplosionController extends Controller implements Collider {
    private Animation animation ;
    public ExplosionController(GameRect gameRect){
        super(gameRect,null);
        ArrayList<Image> images = new ArrayList<>();
        images.add(Utils.loadImage("res/explosion1.png"));
        images.add(Utils.loadImage("res/explosion2.png"));
        images.add(Utils.loadImage("res/explosion3.png"));
        images.add(Utils.loadImage("res/explosion4.png"));
        images.add(Utils.loadImage("res/explosion5.png"));
        images.add(Utils.loadImage("res/explosion6.png"));
        this.animation = new Animation(images,5,true);
        CollisionManager.instance.add(this);
    }
    @Override
    public  void draw(Graphics graphics){
        animation.draw(graphics,gameRect);
        if (animation.isHasEnded()){
            gameRect.setDead(true);
        }

    }

    @Override
    public void onCollider(Collider other) {

    }
}
