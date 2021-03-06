package game;

import Controllers.CollisionManager;
import Controllers.ControllerManager;

import scenes.GameScene;

import scenes.Startscene;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.IOException;


/**
 * Created by hieuv on 4/10/2017.
 */
public class GameWinDow  extends Frame {

    GameScene curremtScene;

    public void setCurremtScene(GameScene curremtScene) {
        this.curremtScene = curremtScene;
    }
    public  static  GameWinDow instance;

    BufferedImage backBufferedImage ;
    Graphics backbufferGraphics;
    int sizeMapX = 600;
    int sizeMapY = 800;




    //





    public GameWinDow() throws IOException {
        instance = this;
        curremtScene = new Startscene();


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
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }


        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                curremtScene.keyPressed(keyEvent);

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                curremtScene.keyReleased(keyEvent);




            }
        });


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(17);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    curremtScene.update();




                    ControllerManager.instance.update();
                    ControllerManager.instance.Shot();



                    CollisionManager.instance.update();



                    repaint();

                }
            }
        });
        thread.start();


    }

    @Override
    public void update(Graphics g) {
        curremtScene.draw(backbufferGraphics);
        ControllerManager.instance.draw(backbufferGraphics);
        g.drawImage(backBufferedImage,0,0,null);
    }
}
