import java.util.ArrayList;

/**
 * Created by simon_clark on 1/20/17.
 */
public class Level {
    private ArrayList<GameObject> objects;

    public Level() {
        objects = new ArrayList<GameObject>();
    }

    public void addGameObject(GameObject g){
        objects.add(g);
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }
}
