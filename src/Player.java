import java.awt.*;

/**
 * Created by Simon on 12/5/2016.
 */
public class Player extends GameObject {

    boolean onPlatform;

    public Player(Color c) {
        super(c);
        onPlatform = false;
    }

    public void detectPlatformCollision(){}

}
