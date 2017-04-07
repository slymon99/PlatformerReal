import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Simon on 12/5/2016.
 */
public class Player extends GameObject {

    private int ticksSinceJumped;

    public Player(Color c) {
        super(c);
        ticksSinceJumped = 0;
    }

    public Ray getJumpDetectionRay() {
        return (new Ray(getWorldCenter(), (3 * Math.PI) / 2));
    }

    public Ray getJumpDetectionRayLeft() {
        double width = ((org.dyn4j.geometry.Rectangle) (getFixture(0).getShape())).getWidth();
        return (new Ray(getWorldCenter().subtract(width / 2.0 - .1, 0), 3 * Math.PI / 2));
    }

    public Ray getJumpDetectionRayRight() {
        double width = ((org.dyn4j.geometry.Rectangle) (getFixture(0).getShape())).getWidth();
        return (new Ray(getWorldCenter().add(width / 2.0 - .1, 0), 3 * Math.PI / 2));
    }


    public void tickUp() {
        ticksSinceJumped++;
    }

    public void jump() {
        ticksSinceJumped = 0;
    }

    public boolean canJump() {
        return (ticksSinceJumped > 30);
    }


}
