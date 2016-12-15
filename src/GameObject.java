import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Convex;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GameObject extends Body {
    /** The color of the object */
    protected Color color;


    /**
     * Default constructor.
     */
    public GameObject() {
        // randomly generate the color
        this.color = new Color(
                (float)Math.random() * 0.5f + 0.5f,
                (float)Math.random() * 0.5f + 0.5f,
                (float)Math.random() * 0.5f + 0.5f);
    }

    public GameObject(Color c) {
        this.color = c;
    }

    /**
     * Draws the body.
     * <p>
     * Only coded for polygons and circles.
     * @param g the graphics object to render to
     */
    public void render(Graphics2D g) {
        // save the original transform
        AffineTransform ot = g.getTransform();

        // transform the coordinate system from world coordinates to local coordinates
        AffineTransform lt = new AffineTransform();
        lt.translate(this.transform.getTranslationX() * 45, this.transform.getTranslationY() * 45);
        lt.rotate(this.transform.getRotation());

        // apply the transform
        g.transform(lt);

        // loop over all the body fixtures for this body
        for (BodyFixture fixture : this.fixtures) {
            // get the shape on the fixture
            Convex convex = fixture.getShape();
            Graphics2DRenderer.render(g, convex, 45, color);
        }

        // set the original transform
        g.setTransform(ot);
    }
}