import org.dyn4j.collision.narrowphase.Raycast;
import org.dyn4j.dynamics.*;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.*;

import org.dyn4j.dynamics.BodyFixture;

import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Vector2;

/**
 * Created by Simon on 12/3/2016.
 */
public class GamePanel extends JPanel implements KeyListener {

    private boolean stopped;
    private GameWorld world;

    private ArrayList<MovingPlatform> movingPlatforms;

    private long last;
    private boolean[] keys;

    public static final double NANO_TO_BASE = 1.0e9;

    public static final double SCALE = 10.0;

    public GamePanel() {
        keys = new boolean[1000];
        addKeyListener(this);

        movingPlatforms = new ArrayList<MovingPlatform>();

        // make sure we are not stopped
        this.stopped = false;

        // setup the world
        this.initializeWorld();


    }

    public void initializeWorld() {
        world = new GameWorld();

        LevelController lc = new LevelController();
        lc.readLevel(1);

        Rectangle floorRect = new Rectangle(15.0, 7.0);
        GameObject floor = new GameObject();
        floor.addFixture(new BodyFixture(floorRect));
        floor.setMass(MassType.INFINITE);
        // move the floor down a bit
        floor.translate(0.0, -4.0);
        this.world.addBody(floor);



        // create a triangle object
//        Triangle triShape = new Triangle(
//                new Vector2(0.0, 0.5),
//                new Vector2(-0.5, -0.5),
//                new Vector2(0.5, -0.5));
//        Player triangle = new Player(Color.green);
//        triangle.addFixture(triShape);
//        Mass m = new Mass(new Vector2(0,0),20.0,20.0);
//        triangle.setMass(m);
//        triangle.translate(-1.0, 2.0);
//        // test having a velocity
//        triangle.getLinearVelocity().set(5.0, 0.0);
//        world.addSquat(triangle);
        Rectangle squatRect = new Rectangle(1.5, 1.5);
        Player squat = new Player(Color.GREEN);
        squat.addFixture(squatRect, 0.5, 0.2, 0);
        Mass squatMass = new Mass(new Vector2(0, 0), 10, 1);
        squat.setMass(squatMass);
        squat.setMassType(MassType.FIXED_ANGULAR_VELOCITY);


        world.addSquat(squat);

        //makes lanky
        Rectangle lankyRect = new Rectangle(1, 3);
        Player lanky = new Player(Color.BLUE);
        lanky.addFixture(lankyRect, 0.5, 0.2, 0);
        Mass lankyMass = new Mass(new Vector2(0, 0), 10, 1);
        lanky.setMass(lankyMass);
        lanky.setMassType(MassType.FIXED_ANGULAR_VELOCITY);

        world.addLanky(lanky);

        MovingPlatform testMovePlatform = new MovingPlatform(new Vector2(-5, 5), new Vector2(-5, 5), new Vector2(0, 0), 5, 1, 1);
        world.addBody(testMovePlatform);
        movingPlatforms.add(testMovePlatform);


//        world.raycast()

//        // create a circle
//        Circle cirShape = new Circle(0.5);
//        GameObject circle = new GameObject();
//        circle.addFixture(cirShape);
//        circle.setMass(MassType.NORMAL);
//        circle.translate(2.0, 2.0);
//        // test adding some force
//        circle.applyForce(new Vector2(-100.0, 0.0));
//        // set some linear damping to simulate rolling friction
//        circle.setLinearDamping(0.05);
//        this.world.addBody(circle);
//
//        // try a rectangle
//        Rectangle rectShape = new Rectangle(1.0, 1.0);
//        GameObject rectangle = new GameObject();
//        rectangle.addFixture(rectShape);
//        rectangle.setMass(MassType.NORMAL);
//        rectangle.translate(0.0, 2.0);
//        rectangle.getLinearVelocity().set(-5.0, 0.0);
//        this.world.addBody(rectangle);
//
//        // try a polygon with lots of vertices
//        Polygon polyShape = Geometry.createUnitCirclePolygon(10, 1.0);
//        GameObject polygon = new GameObject();
//        polygon.addFixture(polyShape);
//        polygon.setMass(MassType.NORMAL);
//        polygon.translate(-2.5, 2.0);
//        // set the angular velocity
//        polygon.setAngularVelocity(Math.toRadians(-20.0));
//        this.world.addBody(polygon);

        // try a compound object
//        Circle c1 = new Circle(0.5);
//        BodyFixture c1Fixture = new BodyFixture(c1);
//        c1Fixture.setDensity(0.5);
//        Circle c2 = new Circle(0.5);
//        BodyFixture c2Fixture = new BodyFixture(c2);
//        c2Fixture.setDensity(0.5);
//        Rectangle rm = new Rectangle(2.0, 1.0);
//        // translate the circles in local coordinates
//        c1.translate(-1.0, 0.0);
//        c2.translate(1.0, 0.0);
//        GameObject capsule = new GameObject();
//        capsule.addFixture(c1Fixture);
//        capsule.addFixture(c2Fixture);
//        capsule.addFixture(rm);
//        capsule.setMass(MassType.NORMAL);
//        capsule.translate(0.0, 4.0);
//        this.world.addBody(capsule);


//        GameObject issTri = new GameObject();
//        issTri.addFixture(Geometry.createIsoscelesTriangle(1.0, 3.0));
//        issTri.setMass(MassType.NORMAL);
//        issTri.translate(2.0, 3.0);
//        this.world.addBody(issTri);
//
//        GameObject equTri = new GameObject();
//        equTri.addFixture(Geometry.createEquilateralTriangle(2.0));
//        equTri.setMass(MassType.NORMAL);
//        equTri.translate(3.0, 3.0);
//        this.world.addBody(equTri);
//
//        GameObject rightTri = new GameObject();
//        rightTri.addFixture(Geometry.createRightTriangle(2.0, 1.0));
//        rightTri.setMass(MassType.NORMAL);
//        rightTri.translate(4.0, 3.0);
//        this.world.addBody(rightTri);
//
//        GameObject cap = new GameObject();
//        cap.addFixture(new Capsule(1.0, 0.5));
//        cap.setMass(MassType.NORMAL);
//        cap.translate(-3.0, 3.0);
//        this.world.addBody(cap);
//
//        GameObject slice = new GameObject();
//        slice.addFixture(new Slice(0.5, Math.toRadians(120)));
//        slice.setMass(MassType.NORMAL);
//        slice.translate(-3.0, 3.0);
//        this.world.addBody(slice);
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

        passKeys();

        world.update(elapsedTime);
        updateAllPlatforms();

        repaint();
    }

    private void passKeys() {

        Player lanky = world.getLanky();
        Player squat = world.getSquat();

        if (isKeyPressed(KeyEvent.VK_A)) {
            squat.applyForce(new Force(-10, 0));
        }
        if (isKeyPressed(KeyEvent.VK_D)) {
            squat.applyForce(new Force(10, 0));
        }

        ArrayList<RaycastResult> result = new ArrayList<RaycastResult>(); //no idea what this does
        boolean canJump = world.raycast(squat.getJumpDetectionRay(), 0.78, false, false, true, result) && squat.canJump();

        if (isKeyPressed(KeyEvent.VK_W) && canJump) {
            squat.applyImpulse(new Vector2(0, 50));
            squat.jump();
        }

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            lanky.applyForce(new Force(-9, 0));
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            lanky.applyForce(new Force(9, 0));
        }

        ArrayList<RaycastResult> result2 = new ArrayList<RaycastResult>(); //no idea what this does
        boolean canJump2 = world.raycast(world.getLanky().getJumpDetectionRay(), 1.6, false, false, true, result2) && lanky.canJump();

        if (isKeyPressed(KeyEvent.VK_UP) && canJump2) {
            lanky.applyImpulse(new Vector2(0, 100));
            lanky.jump();
        }

        squat.tickUp();
        lanky.tickUp();

    }

    private void render(Graphics2D g) {


        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
        AffineTransform move = AffineTransform.getTranslateInstance(720, -425);
        g.transform(yFlip);
        g.transform(move);
        // lets move the view up some
//        g.translate(0.0, -1.0 * SCALE);

        // draw all the objects in the world
        for (int i = 0; i < this.world.getBodyCount(); i++) {
            // get the object
            GameObject go = (GameObject) this.world.getBody(i);
            // draw the object
            go.render(g);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
//        AffineTransform move = AffineTransform.getTranslateInstance(0, -600);
//        g2.transform(yFlip);
//        g2.transform(move);

//        g2.setColor(new Color(210,214,217));
//        g2.fillRect(0,0,2000,2000);

        //let the worldDepreciated render all sprites
//        worldDepreciated.render(g2);

        render(g2);
    }

    private void updateAllPlatforms() {
        for (MovingPlatform p : movingPlatforms) {
            p.update();
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

    public boolean isKeyPressed(int code) {
        return keys[code];
    }

    public void stop() {
        stopped = true;
    }

    public boolean isStopped() {
        return stopped;
    }
}
