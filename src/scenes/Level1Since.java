package scenes;

import Controllers.ControllerManager;

import Controllers.LandController;
import enemies.EnemyController;
import game.Background;
import game.Inputmaneger;
import game.Plane;
import utils.Utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hieuv on 5/6/2017.
 */
public class Level1Since  implements  GameScene{
    int sizeMapX;
    int sizeMapY;
    int kiemtraem=0;
    Background background;
    Background background2;
    private int timeplanelv=0;





    EnemyController enemyController;
    Plane plane ;
    Inputmaneger inputmaneger= new Inputmaneger();
    ArrayList<Image> images1 = new ArrayList<>();
    ArrayList<Image> images2 = new ArrayList<>();
    ArrayList<Image> images3 = new ArrayList<>();




    public Level1Since(int sizeMapX,int sizeMapY) {
        plane = new Plane(sizeMapX/2,sizeMapY-100, Utils.loadImage("res/plane3.png"),sizeMapX,sizeMapY);

        this.sizeMapX = sizeMapX;
        this.sizeMapY= sizeMapY;
        taoenemy();
        background = new Background("res/sea.png",false);
        background2 = new Background("res/sea.png",true);

        images1.add(Utils.loadImage("res/enemy-green-1.png"));
        images1.add(Utils.loadImage("res/enemy-green-2.png"));
        images1.add(Utils.loadImage("res/enemy-green-3.png"));

        images2.add(Utils.loadImage("res/enemy_plane_white_1.png"));
        images2.add(Utils.loadImage("res/enemy_plane_white_2.png"));
        images2.add(Utils.loadImage("res/enemy_plane_white_3.png"));

        images3.add(Utils.loadImage("res/enemy_plane_yellow_1.png"));
        images3.add(Utils.loadImage("res/enemy_plane_yellow_2.png"));
        images3.add(Utils.loadImage("res/enemy_plane_yellow_3.png"));





    }

    public void keyPressed(KeyEvent keyEvent) {
        inputmaneger.keyPressed(keyEvent);
    }
    public void update(){


        kiemtraem++;
        if (kiemtraem==300){
            taoenemy();
            kiemtraem=0;
        }

        plane.move(inputmaneger);
        background.update();
        background2.update();
        plane.update();
        try {
            plane.Shot();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics graphics){
        background.draw(graphics);
        background2.draw(graphics);
        plane.draw(graphics);

    }

    public void keyReleased(KeyEvent keyEvent) {

        inputmaneger.keyReleased(keyEvent);


    }
    public void taoenemy(){
        timeplanelv++;

        for (int i = 0; i<8; i++){
            Random random = new Random();
            int j = random.nextInt(3) + 1;
            if (j==1){

                enemyController = new EnemyController(sizeMapX,sizeMapY,images1);
                enemyController.setMoveBeHavior(j);


            }else {
                if (j==2){
                    enemyController = new EnemyController(sizeMapX,sizeMapY,images2);
                    enemyController.setMoveBeHavior(j);
                }else {
                    enemyController = new EnemyController(sizeMapX,sizeMapY,images3);
                    enemyController.setMoveBeHavior(3);
                }
            }
            if (timeplanelv==6){
                enemyController.isPlanelever=true;
                timeplanelv=0;
            }

            ControllerManager.instance.add(enemyController);

        }
    }

}
