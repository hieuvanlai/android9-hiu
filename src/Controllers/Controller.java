package Controllers;

import View.ImageRenderer;
import models.GameRect;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.util.Random;

/**
 * Created by hieuv on 5/2/2017.
 */
public class Controller {
    protected GameRect gameRect;
    protected ImageRenderer imageRenderer;

    public Controller(GameRect gameRect, ImageRenderer imageRenderer) {
        this.gameRect = gameRect;
        this.imageRenderer = imageRenderer;
    }

    public Controller() {
    }
    public GameRect getGameRect() {
        return gameRect;
    }



    public void draw(Graphics graphics){
        imageRenderer.render(graphics,gameRect);
    }
    public void  update(){

    }
    public void Shot() throws UnsupportedAudioFileException {

    }
}
