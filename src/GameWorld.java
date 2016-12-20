import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;


/**
 * Created by simon_clark on 12/15/16.
 */
public class GameWorld extends World{
    private Player squat, lanky;

    public void addSquat(Player s){
        squat =  s;
        addBody(s);
    }

    public void addLanky(Player l){
        lanky =  l;
        addBody(l);
    }

    public Player getSquat() {
        return squat;
    }

    public Player getLanky() {
        return lanky;
    }
}
