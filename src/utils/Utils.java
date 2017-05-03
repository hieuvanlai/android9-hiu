package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by hieuv on 4/15/2017.
 */
public class Utils {
    public  static Image loadImage(String path){
        try {
            Image a = ImageIO.read(new File(path));
            return a;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public  static Random random = new Random();

}
