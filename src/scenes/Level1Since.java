package scenes;

import Controllers.ControllerManager;
import enemies.EnemyController;
import game.Background;
import game.Inputmaneger;
import game.Plane;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by hieuv on 5/6/2017.
 */
public class Level1Since  implements  GameScene{
    int sizeMapX;
    int sizeMapY;
    int kiemtraem=0;
    Background background;


    EnemyController enemyController;
    Plane plane ;
    Inputmaneger inputmaneger= new Inputmaneger();

    public Level1Since(int sizeMapX,int sizeMapY) {
        plane = new Plane(sizeMapX/2,sizeMapY-100, Utils.loadImage("res/plane2.png"),sizeMapX,sizeMapY);
        this.sizeMapX = sizeMapX;
        this.sizeMapY= sizeMapY;
        taoenemy();
        background = new Background("res/sea.png");
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
        plane.update();
        plane.Shot();
    }
    public void draw(Graphics graphics){
        background.draw(graphics);
        plane.draw(graphics);

    }

    public void keyReleased(KeyEvent keyEvent) {

        inputmaneger.keyReleased(keyEvent);


    }
    public void taoenemy(){

        for (int i = 0; i<8; i++){
            Random random = new Random();
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


            ControllerManager.instance.add(enemyController);



        }
    }

}
