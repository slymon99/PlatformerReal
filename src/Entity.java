import java.awt.*;

/**
 * Created by Simon on 12/3/2016.
 */
public class Entity extends Rectangle{
    double velX, velY;
    double dx, dy;

    public Entity(int x, int y, int w, int h){
        super(x,y,w,h);

        velX = 0;
        velY = 0;
        dx = 0;
        dy = 0;
    }

    public void draw(Graphics2D g2){
        g2.fill(this);
    }

    public void move(double elapsedTime){
        dx += velX * elapsedTime;
        System.out.println(dx);
    }

    public void moveLeft(double elapsedTime) {
        if (velX >= -6) {
            velX -= 2000*elapsedTime;
        }
    }

    public void moveRight(double elapsedTime) {
        if (velX <= 6) {
            velX += 2000*elapsedTime;
        }
    }


}
