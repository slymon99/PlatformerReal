import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by Simon on 12/3/2016.
 */
public class WorldDepreciated {

//    private ArrayList<Block> blocks;
//
//    private Player squat;
//    private Player lanky;
//
//    private boolean[] keys;
//
//    public static final boolean DEBUG = true;
//
//
//    public WorldDepreciated() {
//
//        blocks = new ArrayList<Block>();
//
//        squat = new Player(10, 10, 55, 65, 70, 100);
//        lanky = new Player(100, 10, 30, 125, 80, 100);
//        addBlock(squat);
//        addBlock(lanky);
//
//        keys = new boolean[1000];
//
//    }
//
//    public void update(double elapsedTime, boolean[] keysPressed) {
//        squat.move(elapsedTime);
//        keys = keysPressed;
//
//        if (isKeyPressed(KeyEvent.VK_A)) {
//            squat.accelerateLeft(elapsedTime);
//        } else {
//            squat.stopAcceleratingLeft();
//        }
//        if (isKeyPressed(KeyEvent.VK_D)) {
//            squat.accelerateRight(elapsedTime);
//        } else {
//            squat.stopAcceleratingRight();
//        }
//
//        if (isKeyPressed(KeyEvent.VK_LEFT)) {
//            lanky.accelerateLeft(elapsedTime);
//        } else {
//            lanky.stopAcceleratingLeft();
//        }
//        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
//            lanky.accelerateRight(elapsedTime);
//        } else {
//            lanky.stopAcceleratingRight();
//        }
//
//        squat.move(elapsedTime);
//        lanky.move(elapsedTime);
//
//        squat.printDiagnostics();
//    }
//
//    public void render(Graphics2D g2) {
//        for (int i = 0; i < blocks.size(); i++) {
//            Block e = blocks.get(i);
//            e.draw(g2);
//
//        }
//    }
//
//    public void addBlock(Block e) {
//        blocks.add(e);
//    }
//
//
//    public ArrayList<Block> getBlocks() {
//        return blocks;
//    }
//
//    public Block getBlock(int i) {
//        return blocks.get(i);
//    }
//
//
//    public boolean isKeyPressed(int code) {
//        return keys[code];
//    }

}
