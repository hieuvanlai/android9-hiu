package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
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
