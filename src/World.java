import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by Simon on 12/3/2016.
 */
public class World{

    private ArrayList<Entity> entities;

    private Entity squat;
    private Entity lanky;

    private boolean[] keys;

    public World(){

        entities = new ArrayList<Entity>();

        squat = new Entity(10,10,55,65, 70, 35);
        lanky = new Entity(100,10,30,125, 80, 20);
        addEntity(squat);
        addEntity(lanky);

        keys = new boolean[1000];

    }

    public void update(double elapsedTime, boolean[] keysPressed){

//        squat.move(elapsedTime);
        keys = keysPressed;

        if(isKeyPressed(KeyEvent.VK_A)){
            squat.accelerateLeft(elapsedTime);
        }
        if(isKeyPressed(KeyEvent.VK_D)){
            squat.accelerateRight(elapsedTime);
        }

        if(isKeyPressed(KeyEvent.VK_LEFT)){
            lanky.accelerateLeft(elapsedTime);
        }
        if(isKeyPressed(KeyEvent.VK_RIGHT)){
            lanky.accelerateRight(elapsedTime);
        }

        squat.move(elapsedTime);
        lanky.move(elapsedTime);

        squat.printDiagnostics();
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




    public boolean isKeyPressed(int code) {
        return keys[code];
    }

}
