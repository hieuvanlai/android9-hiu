package enemies;

import models.GameRect;

/**
 * Created by hieuv on 4/18/2017.
 */
public class MoveBeHavior {
    public  void move(GameRect gameRect){
        gameRect.move(0,3);
    }

    public  void movebackgroud(GameRect gameRect){

            gameRect.move(0,1);


    }
    public  void moveleft(GameRect gameRect){
        gameRect.move(-1,1);

    }
    public void moveright(GameRect gameRect){
        gameRect.move(1,1);
    }
}
