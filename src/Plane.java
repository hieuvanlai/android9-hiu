import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hieuv on 4/12/2017.
 */
 public class Plane {
    private int planeX;
    private  int planeY;
    private Image image;
    private int sizeMapX;
    private int sizeMapY;

    ArrayList<Bullet> bullets;


    int dy;
    int dx;
    int shotdelay;

    public Plane(int planeX, int planeY, Image image,int sizeMapX,int sizeMapY) {
        this.planeX = planeX;
        this.planeY = planeY;
        this.image = image;
        this.sizeMapX= sizeMapX;
        this.sizeMapY= sizeMapY;
        bullets = new ArrayList<>();
        shotdelay=10;

    }

    public void move(Inputmaneger inputmaneger){
        dx=0;
        dy=0;
        if (inputmaneger.isAPressed && planeX+dx>=0) dx -=4;
        if (inputmaneger.isDPressed &&  planeX+dx<=sizeMapX-60 ) dx +=4;
        if (inputmaneger.isWPressed &&  planeY+dy>=30 ) dy -=4;
        if (inputmaneger.isSPressed && planeY+dy<=sizeMapY-50 ) dy +=4;


    }
    public void Shot(Inputmaneger inputmaneger){
        shotdelay--;
        if (shotdelay==0){
            if (inputmaneger.isENTERPressed){
                Bullet bul = null;
                try {
                    bul = new Bullet(planeX+30,planeY, ImageIO.read(new File("res/bullet.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bullets.add(bul);
            }
            shotdelay=10;
        }


    }

    public int getPlaneX() {
        return planeX;
    }

    public void setPlaneX(int planeX) {
        this.planeX = planeX;
    }

    public int getPlaneY() {
        return planeY;
    }

    public void setPlaneY(int planeY) {
        this.planeY = planeY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void  draw(Graphics graphics){
        graphics.drawImage(this.image,this.planeX,this.planeY,null);
        for (Bullet b: bullets){
            b.draw(graphics);
        }
    }

    public  void update(){
        this.planeX+=dx;
        this.planeY+=dy;
        for (Bullet bullet1:bullets){
            bullet1.updateup();
        }

    }



}
