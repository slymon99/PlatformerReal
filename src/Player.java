import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Ray;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Simon on 12/5/2016.
 */
public class Player extends GameObject {

    private boolean landed;

    public Player(Color c) {
        super(c);
        landed = false;
    }

    public void detectLandedness(List<Body> bodies){


        for (Body b: bodies) {
            if(!b.equals(this)){
//                System.out.println(b.getFixture(b.getWorldCenter()).getShape());
//                System.out.println(getWorldCenter().getYComponent().subtract(b.getWorldCenter().getYComponent()));
//                System.out.println(b.getWorldCenter().getYComponent().getMagnitude());

            }


        }

    }

    public Ray getJumpDetectionRay(){
        return(new Ray(getWorldCenter(), 3*Math.PI/2));
    }

}
