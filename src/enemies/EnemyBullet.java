package enemies;

import java.awt.*;

/**
 * Created by hieuv on 4/15/2017.
 */
public class EnemyBullet {
    private  int x;
    private int y ;
    private Image image;

    public EnemyBullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public void  draw(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,null);
    }
    public  void updateup(){
        this.y-=15;
    }
    public  void updatedown(){
        this.y+=10;
    }
}
