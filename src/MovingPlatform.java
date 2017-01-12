import org.dyn4j.geometry.MassType;

/**
 * Created by john_gordon on 1/12/17.
 */
public class MovingPlatform extends Platform {
    private double x1, x2, y1, y2,  xVel, yVel, width, height;

    public MovingPlatform(double ex1, double why1, double w1dth, double he1ght, double ex2, double why2, double xSpeed, double ySpeed ){
        super(ex1, why1, w1dth, he1ght);

        x1= ex1;
        x2=ex2;
        width = w1dth;
        height = he1ght;
        y1=why1;
        y2=why2;
        xVel=xSpeed;
        yVel=ySpeed;

        super.translate(x1,y1);

        super.setLinearVelocity(xSpeed,ySpeed);
    }



}
