/**
 * Created by Simon on 12/5/2016.
 */
public class Player extends Block {
    private double velX, velY;
    private double dx, dy;
    private double maxHorizontalSpeed;
    private double horizontalAcceleration;
    private boolean acceleratingLeft, acceleratingRight;

    public Player(int x, int y, int w, int h, double hSpeed, double hAccel) {
        super(x, y, w, h);

        maxHorizontalSpeed = hSpeed;
        horizontalAcceleration = hAccel;

        acceleratingLeft = false;
        acceleratingRight = false;

        velX = 0;
        velY = 0;
        dx = 0;
        dy = 0;

    }

    public void move(double elapsedTime) {

        //x velocity calculations

        if (!acceleratingLeft && velX < -5) {
            velX += horizontalAcceleration * elapsedTime;
        }

        if (!acceleratingRight && velX > 5) {
            velX -= horizontalAcceleration * elapsedTime;
        }

        if (Math.abs(velX) < 5 && !acceleratingRight && !acceleratingLeft) {
            velX = 0;
        }


        //x displacement calculations

        dx += velX * elapsedTime;


        //calculate the delta pixels, move the x by that many pixels
        //then subtract that many from delta x

        int dxPixels = (int) (dx);

        //hold onto dxPixels and use it for collisions

        if (dxPixels != 0) {
            moveX(dxPixels);
            dx -= dxPixels;
        }

        //y calculations


    }

    public void printDiagnostics(){
        System.out.println("velX: " + velX + " velY: " + velY + " x: " + getX() + " y: " + getY() + " dx: " + dx + " dy: " + dy);
    }

    public void accelerateLeft(double elapsedTime) {
        acceleratingLeft = true;
        if (velX >= -maxHorizontalSpeed) {
            velX -= horizontalAcceleration * elapsedTime;
        }
    }

    public void stopAcceleratingLeft() {
        acceleratingLeft = false;
    }

    public void accelerateRight(double elapsedTime) {
        acceleratingRight = true;
        if (velX <= maxHorizontalSpeed) {
            velX += horizontalAcceleration * elapsedTime;
        }
    }

    public void stopAcceleratingRight() {
        acceleratingRight = false;
    }


}
