import org.dyn4j.dynamics.*;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

/**
 * Created by Simon on 12/3/2016.
 */
public class GamePanel extends JPanel implements KeyListener{

    private WorldDepreciated worldDepreciated;

    private boolean stopped;
    private World world;

    private long last;
    private boolean[] keys;

    public static final double NANO_TO_BASE = 1.0e9;

    public GamePanel() {
        keys = new boolean[1000];
        addKeyListener(this);

        world = new World();
//        // create a canvas to paint to
//        this.canvas = new Canvas();
//        this.canvas.setPreferredSize(size);
//        this.canvas.setMinimumSize(size);
//        this.canvas.setMaximumSize(size);
//
//        // add the canvas to the JFrame
//        this.add(this.canvas);
//
//        // make the JFrame not resizable
//        // (this way I dont have to worry about resize events)
//        this.setResizable(false);
//
//        // size everything
//        this.pack();

        // make sure we are not stopped
        this.stopped = false;

        // setup the worldDepreciated
        this.initializeWorld();
    }

    public void initializeWorld() {
        worldDepreciated = new WorldDepreciated();
        worldDepreciated.addBlock(new Block(0,0,200,10));

        world = new World();
        org.dyn4j.geometry.Rectangle floorRect = new org.dyn4j.geometry.Rectangle(15.0, 1.0);

        GameObject floor = new GameObject();
        floor.addFixture(new BodyFixture(floorRect));
        floor.setMass(MassType.INFINITE);
        // move the floor down a bit
        floor.translate(0.0, -4.0);
        this.world.addBody(floor);

        // create a triangle object
        Triangle triShape = new Triangle(
                new Vector2(0.0, 0.5),
                new Vector2(-0.5, -0.5),
                new Vector2(0.5, -0.5));
        GameObject triangle = new GameObject();
        triangle.addFixture(triShape);
        triangle.setMass(MassType.NORMAL);
        triangle.translate(-1.0, 2.0);
        // test having a velocity
        triangle.getLinearVelocity().set(5.0, 0.0);
        this.world.addBody(triangle);
    }

    public void start() {
        // initialize the last update time
        this.last = System.nanoTime();
        // don't allow AWT to paint the canvas since we are
//        this.canvas.setIgnoreRepaint(true);
        // enable double buffering (the JFrame has to be
        // visible before this can be done)
//        this.canvas.createBufferStrategy(2);
        // run a separate thread to do active rendering
        // because we don't want to do it on the EDT
        Thread thread = new Thread() {
            public void run() {
                // perform an infinite loop stopped
                // render as fast as possible
                while (!isStopped()) {
                    gameLoop();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // you could add a Thread.yield(); or
                    // Thread.sleep(long) here to give the
                    // CPU some breathing room
                }
            }
        };
        // set the game loop thread to a daemon thread so that
        // it cannot stop the JVM from exiting
        thread.setDaemon(true);
        // start the game loop
        thread.start();
    }

    private void gameLoop() {

        // update the World

        // get the current time
        long time = System.nanoTime();
        // get the elapsed time from the last iteration
        long diff = time - this.last;
        // set the last time
        this.last = time;
        // convert from nanoseconds to seconds
        double elapsedTime = diff / NANO_TO_BASE;
        // update the worldDepreciated with the elapsed time and current keys pressed
        this.worldDepreciated.update(elapsedTime, keys);
        world.update(elapsedTime);

        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
        AffineTransform move = AffineTransform.getTranslateInstance(0, -600);
        g2.transform(yFlip);
        g2.transform(move);

//        g2.setColor(new Color(210,214,217));
//        g2.fillRect(0,0,2000,2000);

        //let the worldDepreciated render all sprites
        worldDepreciated.render(g2);

        for (int i = 0; i < this.world.getBodyCount(); i++) {
            // get the object
            GameObject go = (GameObject) this.world.getBody(i);
            // draw the object
            go.render(g2);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    public void stop() {
        stopped = true;
    }

    public boolean isStopped() {
        return stopped;
    }
}
