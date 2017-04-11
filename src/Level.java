import java.awt.*;
import java.util.ArrayList;

/**
 * Created by simon_clark on 1/20/17.
 */
public class Level {
    private ArrayList<GameObject> objects;
    private Point squat, lanky, goal;

    public Level(ArrayList<GameObject> obj) {
        objects = obj;
    }

    public void setObjects(ArrayList<GameObject> arr){
        objects = arr;
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void setInfo(Point s, Point l , Point g){
        squat = s;
        lanky = l;
        goal = g;
    }

    public Point getSquatPoint() {
        return squat;
    }

    public Point getLankyPoint() {
        return lanky;
    }

    public Point getGoalPoint() {
        return goal;
    }

    public void InfoToString(){
        System.out.println(squat + " " + lanky + " " + goal);
    }
}
