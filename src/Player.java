import org.dyn4j.dynamics.Body;

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
                System.out.println(b.getWorldCenter().difference(getWorldCenter()).getYComponent().getMagnitude());
            }


        }

    }

}
