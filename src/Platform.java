import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Vector2;

import java.awt.*;

/**
 * Created by john_gordon on 1/12/17.
 */
public class Platform extends GameObject{

    public Platform(double x, double y, double width, double height){

        super.setMassType(MassType.INFINITE);
        super.addFixture(new Rectangle(width, height));
        super.translate(x, y);

        color = Color.getHSBColor(0,0,((float)y/40.0f));
        setColor(color);

    }

    public Platform(Vector2 start, double width, double height){

        super.setMassType(MassType.INFINITE);
        super.addFixture(new Rectangle(width, height));
        super.translate(start);


    }


}
