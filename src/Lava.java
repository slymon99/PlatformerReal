import org.dyn4j.geometry.Vector2;

import java.awt.*;

/**
 * Created by simon_clark on 3/28/17.
 */
public class Lava extends Platform{
    public Lava(double x, double y, double width, double height) {
        super(x, y, width, height);
        super.setColor(new Color(235, 89, 78));
    }

    public Lava(Vector2 start, double width, double height) {
        super(start, width, height);
    }


}
