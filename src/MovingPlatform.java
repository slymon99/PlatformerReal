import org.dyn4j.geometry.Vector2;

/**
 * Created by john_gordon on 1/12/17.
 */
public class MovingPlatform extends Platform {
    private double speed;
    private Vector2 start, end;

    public MovingPlatform(Vector2 spawn, Vector2 start, Vector2 end, double speed, double width, double height) {
        super(spawn, width, height);

        this.start = start;
        this.end = end;
        this.speed = speed;

        super.setLinearVelocity(this.end.difference(this.start).setMagnitude(this.speed));
    }
    
    public void update(){


        double distanceBetween = start.difference(end).getMagnitude();
        double distanceFromStart = start.difference(getWorldCenter()).getMagnitude();
        double distanceFromEnd = end.difference(getWorldCenter()).getMagnitude();

        if(distanceBetween < distanceFromEnd){
            setLinearVelocity(end.difference(start).setMagnitude(speed));
        }
        else if(distanceBetween < distanceFromStart){
            setLinearVelocity(start.difference(end).setMagnitude(speed));
        }

    }
}
