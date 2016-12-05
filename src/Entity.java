import java.awt.*;

/**
 * Created by Simon on 12/3/2016.
 */
public class Entity{
    private double velX, velY;
    private double dx, dy;
    private int x, y, w, h;
    private double maxHorizontalSpeed;
    private double horizontalAcceleration;

    public Entity(int x, int y, int w, int h, double hSpeed, double hAccel){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        maxHorizontalSpeed = hSpeed;
        horizontalAcceleration = hAccel;

        velX = 0;
        velY = 0;
        dx = 0;
        dy = 0;

    }

    public void draw(Graphics2D g2){
        g2.fillRect(x,y,w,h);
    }

    public void move(double elapsedTime){
        dx += velX * elapsedTime;

        if(dx>1){
            dx-=1;
            x+=1;
        }
        else if(dx<-1){
            dx+=1;
            x-=1;
        }

    }

    public void accelerateLeft(double elapsedTime) {
        if (velX >= -maxHorizontalSpeed) {
            velX -= horizontalAcceleration*elapsedTime;
        }
    }

    public void accelerateRight(double elapsedTime) {
        if (velX <= maxHorizontalSpeed) {
            velX += horizontalAcceleration*elapsedTime;
        }
    }


    public void printDiagnostics(){
        System.out.println("velX: " + velX + " velY: " + velY + " x: " + x + " y: " + y);
    }


}
