package Controllers;

import game.Collider;
import game.Plane;

import java.awt.*;

/**
 * Created by hieuv on 5/9/2017.
 */
public class LandController extends PlaneLeverControler {

    public LandController(int x, int y, Image image) {
        super(x, y, image);
        CollisionManager.instance.add(this);
    }
    @Override
    public void onCollider(Collider other) {

    }

}
