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
    private boolean acceleratingLeft, acceleratingRight;

    public Entity(int x, int y, int w, int h, double hSpeed, double hAccel){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        maxHorizontalSpeed = hSpeed;
        horizontalAcceleration = hAccel;

        acceleratingLeft = false;
        acceleratingRight = false;

        velX = 0;
        velY = 0;
        dx = 0;
        dy = 0;

    }

    public void draw(Graphics2D g2){
        g2.fillRect(x,y,w,h);
    }

    public void drawDebug(Graphics2D g2, int y){
        String debugString = "velX: " + velX + " velY: " + velY + " x: " + x + " y: " + y + " dx: " + dx + " dy: " + dy;
        g2.drawString(debugString, 0, y+100);
    }

    public void move(double elapsedTime){

        //x velocity calculations

        if(!acceleratingLeft && velX < -5){
            velX +=horizontalAcceleration*elapsedTime;
        }

        if(!acceleratingRight && velX > 5){
            velX -=horizontalAcceleration*elapsedTime;
        }

        if(Math.abs(velX)<5 && !acceleratingRight && !acceleratingLeft){
            velX = 0;
        }


        //x displacement calculations

        dx += velX * elapsedTime;


        //calculate the delta pixels, move the x by that many pixels
        //then subtract that many from delta x

        int dxPixels = (int)(dx);

        if(dxPixels!=0){
            x+=dxPixels;
            dx-=dxPixels;
        }

        //y calculations


    }

    public int nextX(double elapsedTime){
        if (dx + velX * elapsedTime > 1){
            return x + 1;
        }
        return 0; //INCOMPLETE
    }

    public void accelerateLeft(double elapsedTime) {
        acceleratingLeft = true;
        if (velX >= -maxHorizontalSpeed) {
            velX -= horizontalAcceleration*elapsedTime;
        }
    }

    public void stopAcceleratingLeft(){
        acceleratingLeft = false;
    }

    public void accelerateRight(double elapsedTime) {
        acceleratingRight = true;
        if (velX <= maxHorizontalSpeed) {
            velX += horizontalAcceleration*elapsedTime;
        }
    }

    public void stopAcceleratingRight(){
        acceleratingRight = false;
    }


    public void printDiagnostics(){
        System.out.println("velX: " + velX + " velY: " + velY + " x: " + x + " y: " + y + " dx: " + dx + " dy: " + dy);
    }


}
