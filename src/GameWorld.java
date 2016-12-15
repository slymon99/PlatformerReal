import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;

import java.util.ArrayList;

/**
 * Created by simon_clark on 12/15/16.
 */
public class GameWorld extends World{
    private Body squat, lanky;

    public void addSquat(Body s){
        squat =  s;
        addBody(s);
    }

    public void addLanky(Body l){
        lanky =  l;
        addBody(l);
    }

    public Body getSquat() {
        return squat;
    }

    public Body getLanky() {
        return lanky;
    }
}
