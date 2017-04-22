import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import enemies.EnemyBullet;
import enemies.EnemyController;
import utils.Utils;

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
import java.util.Random;

/**
 * Created by hieuv on 4/10/2017.
 */
public class GameWinDow  extends Frame {
    Image backgroundImage;

    BufferedImage backBufferedImage ;
    Graphics backbufferGraphics;
    EnemyController enemyController;
    int shortdelayenemy = 120;
    int sizeMapX = 600;
    int sizeMapY = 800;
    int shotdelay = 10;
    ArrayList<EnemyController> enemyControllerlist;
    Plane plane = new Plane(sizeMapX/2,sizeMapY-100,Utils.loadImage("res/plane2.png"),sizeMapX,sizeMapY);
    Inputmaneger inputmaneger= new Inputmaneger();
    ArrayList<EnemyBullet> enemyBulletslist;
    EnemyBullet enemyBullet;
    ArrayList<Bullet> bullets;


    //

    public  void  deleteenemy(){
        for (int x = 0;x<bullets.size();x++){

            for (int i = 0;i<enemyControllerlist.size();i++){
                int kiemttra=0;
                for (int j =0 ;j<50;j++){
                    if ((bullets.get(x).getX()==enemyControllerlist.get(i).getGameRect().getX()+j)){
                        for (int z=0;z<20;z++){
                            if (enemyControllerlist.get(i).getGameRect().getY()+z==bullets.get(x).getY()){
                                enemyControllerlist.remove(i);
                                break;
                            }
                        }
                        break;
                    }
                }
                if (kiemttra==1){
                }
            }
            bullets.get(x).updateup();
        }

    }


    public void taoenemy(){
        for (int i = 0; i<3; i++){
            Random  random = new Random();
            int j = random.nextInt(3) + 1;

            if (j==1){
                enemyController = new EnemyController(Utils.loadImage("res/enemy-green-3.png"),sizeMapX,sizeMapY);
                enemyController.setMoveBeHavior(j);

            }else {
                if (j==2){
                    enemyController = new EnemyController(Utils.loadImage("res/enemy_plane_white_1.png"),sizeMapX,sizeMapY);
                    enemyController.setMoveBeHavior(j);
                }else {
                    enemyController = new EnemyController(Utils.loadImage("res/enemy_plane_yellow_1.png"),sizeMapX,sizeMapY);
                    enemyController.setMoveBeHavior(3);
                }
            }


            enemyControllerlist.add(enemyController);

        }
    }

    public GameWinDow() throws IOException {
        bullets = new ArrayList<>();
        enemyBulletslist = new ArrayList<>();
        enemyControllerlist = new ArrayList<>();
        taoenemy();

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
                    deleteenemy();




                    shortdelayenemy--;
                    if (shortdelayenemy==1){
                        for (EnemyController enemyController:enemyControllerlist){


                            enemyBullet = new EnemyBullet(enemyController.getGameRect().getX(),enemyController.getGameRect().getY(),Utils.loadImage("res/bullet-round.png"));
                            enemyBulletslist.add(enemyBullet);

                        }
                        shortdelayenemy=120;
                    }
                    int kiemtraem=0;

                    for (EnemyController enemyController:enemyControllerlist){

                        enemyController.update();
                        if (enemyController.getGameRect().getY()==sizeMapY){
                            kiemtraem=1;
                        }


                    }
                    if (kiemtraem==1){
                        taoenemy();
                    }
                    if (enemyControllerlist.size()==0){
                        taoenemy();
                    }
                    for (EnemyBullet enemyBullet: enemyBulletslist){
                        enemyBullet.updatedown();
                    }

                    plane.move(inputmaneger);

                    shotdelay--;
                    if (shotdelay==0){
                        if (inputmaneger.isENTERPressed){
                            Bullet bul = null;
                            try {
                                bul = new Bullet(plane.getGameRect().getX()+30,plane.getGameRect().getY(), ImageIO.read(new File("res/bullet.png")));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            bullets.add(bul);
                        }
                        shotdelay=10;
                    }
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
        for (EnemyController enemyController : enemyControllerlist){
            enemyController.draw(backbufferGraphics);
        }
        for (EnemyBullet enemyBullet: enemyBulletslist){
            enemyBullet.draw(backbufferGraphics);
        }
        for (Bullet b: bullets){
            b.draw(backbufferGraphics);
        }

        g.drawImage(backBufferedImage,0,0,null);
    }
}
