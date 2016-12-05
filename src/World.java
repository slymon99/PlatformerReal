import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by Simon on 12/3/2016.
 */
public class World {

    private ArrayList<Entity> entities;

    private Entity squat;
    private Entity lanky;

    private boolean[] keys;

    public static final boolean DEBUG = true;


    public World() {

        entities = new ArrayList<Entity>();

        squat = new Entity(10, 10, 55, 65, 70, 100);
        lanky = new Entity(100, 10, 30, 125, 80, 100);
        addEntity(squat);
        addEntity(lanky);

        keys = new boolean[1000];

    }

    public void update(double elapsedTime, boolean[] keysPressed) {

//        squat.move(elapsedTime);
        keys = keysPressed;

        if (isKeyPressed(KeyEvent.VK_A)) {
            squat.accelerateLeft(elapsedTime);
        } else {
            squat.stopAcceleratingLeft();
        }
        if (isKeyPressed(KeyEvent.VK_D)) {
            squat.accelerateRight(elapsedTime);
        } else {
            squat.stopAcceleratingRight();
        }

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            lanky.accelerateLeft(elapsedTime);
        } else {
            lanky.stopAcceleratingLeft();
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            lanky.accelerateRight(elapsedTime);
        } else {
            lanky.stopAcceleratingRight();
        }

        squat.move(elapsedTime);
        lanky.move(elapsedTime);

        squat.printDiagnostics();
    }

    public void render(Graphics2D g2) {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.draw(g2);

        }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }


    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Entity getEntity(int i) {
        return entities.get(i);
    }


    public boolean isKeyPressed(int code) {
        return keys[code];
    }

}
