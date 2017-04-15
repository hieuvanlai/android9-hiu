import com.sun.javafx.iio.ImageMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hieuv on 4/10/2017.
 */
public class GameWinDow  extends Frame {
    Image backgroundImage;

    BufferedImage backBufferedImage ;
    Graphics backbufferGraphics;

    int sizeMapX = 600;
    int sizeMapY = 800;
    Enemy enemy = new Enemy(Utils.loadImage("res/enemy_plane_white_3.png"),sizeMapX,sizeMapY);
    Plane plane = new Plane(sizeMapX/2,sizeMapY-100,Utils.loadImage("res/plane2.png"),sizeMapX,sizeMapY);
    Inputmaneger inputmaneger= new Inputmaneger();


    //






    public GameWinDow() throws IOException {

        setVisible(true);
        setSize(sizeMapX,sizeMapY);
        backBufferedImage = new BufferedImage(sizeMapX,sizeMapY,BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBufferedImage.getGraphics();


        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                inputmaneger.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

                inputmaneger.keyReleased(keyEvent);


            }
        });
        try {
            backgroundImage = ImageIO.read(new File("res/background.png"));

        } catch (IOException e) {


            e.printStackTrace();
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(17);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    enemy.Shot();
                    enemy.update();

                    plane.move(inputmaneger);
                    plane.Shot(inputmaneger);
                    plane.update();
                    repaint();

                }
            }
        });
        thread.start();


    }

    @Override
    public void update(Graphics g) {
        backbufferGraphics.drawImage(backgroundImage,0,0,sizeMapX,sizeMapY,null);
        plane.draw(backbufferGraphics);
        enemy.draw(backbufferGraphics);

        g.drawImage(backBufferedImage,0,0,null);
    }
}
