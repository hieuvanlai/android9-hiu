package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
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
    public static  Image  xoayanh(Image image){
        // Flip the image vertically
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter((BufferedImage) image, null);


// Flip the image vertically and horizontally; equivalent to rotating the image 180 degrees
        tx = AffineTransform.getScaleInstance(-1, -1);
        tx.translate(-image.getWidth(null), -image.getHeight(null));
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter((BufferedImage) image, null);
        return image;
    }
    public  static Random random = new Random();

    public static void playSound(String audioUrl, boolean repeat) throws UnsupportedAudioFileException {



        File soundFile = new File(audioUrl);

        try {

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);

            clip.start();

            if(repeat) {

                clip.stop();

            }

            else {

                clip.loop(0);

            }

        } catch (UnsupportedAudioFileException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (LineUnavailableException e) {

            e.printStackTrace();

        }

    }

}
