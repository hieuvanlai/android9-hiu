package game;

import Controllers.Controller;
import utils.Utils;

import java.awt.*;

/**
 * Created by hieuv on 5/6/2017.
 */
public class Background extends Controller {
    Image backgroundImage;

    public Background(String s) {
        backgroundImage = Utils.loadImage(s);

    }
    public void draw(Graphics graphics){
        graphics.drawImage(backgroundImage,0,0,null);

    }
    @Override
    public void update(){

    }
}
