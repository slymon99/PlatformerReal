import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Rectangle;

/**
 * Created by john_gordon on 1/12/17.
 */
public class Platform extends GameObject{

    public Platform(double x, double y, double width, double height){

        super.setMassType(MassType.INFINITE);
        super.addFixture(new Rectangle(width, height));
        super.translate(x,y);

    }

}
