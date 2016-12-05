import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


/**
 * Created by Simon on 12/3/2016.
 */
public class World{

    private ArrayList<Entity> entities;

    private Entity squat;
    private Entity lanky;



    public World(){

        entities = new ArrayList<Entity>();

        squat = new Entity(10,10,55,65);
        lanky = new Entity(100,10,30,125);
        addEntity(squat);
        addEntity(lanky);

    }

    public void update(double elapsedTime){

//        squat.move(elapsedTime);
        }

    public void addEntity(Entity e){
        entities.add(e);
    }


    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Entity getEntity(int i){
        return entities.get(i);
    }


    static class EnterAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("enter pressed");
        }
    }
}
