package models;

import java.awt.*;

/**
 * Created by hieuv on 4/15/2017.
 */
public class GameRect {
    private  int x;
    private  int y;
    private int width;
    private  int height;
    private int Hit;

    public int getHit() {
        return Hit;
    }

    public void setHit(int hit) {
        Hit = hit;
    }

    private boolean isDead;

    public boolean isDead() {
        return isDead;
    }

    public GameRect(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public GameRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {

        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public  void move (int dx ,int dy){
        this.x += dx;
        this.y +=dy;
    }



    public boolean intersects(GameRect other){
        Rectangle rect1 = new Rectangle(x,y,width,height);
        Rectangle rect2 = new Rectangle(other.x,other.y,other.width,other.height);
        return rect1.intersects(rect2);

    }
}
