package View;

import models.GameRect;
import utils.Utils;

import java.awt.*;

/**
 * Created by hieuv on 4/15/2017.
 */
public class ImageRenderer {
    private Image image;

    public ImageRenderer(Image image) {
        this.image = image;
    }
    public ImageRenderer(String path) {
        this(Utils.loadImage(path));
    }

    public Image getImage() {
        return image;
    }

    public void render(Graphics graphics, GameRect gameRect){
        graphics.drawImage(image,gameRect.getX(),gameRect.getY(),gameRect.getWidth(),gameRect.getHeight(),null);
    }
}
