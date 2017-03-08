import org.dyn4j.geometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * Created by simon_clark on 1/23/17.
 */
public class LevelEditor extends JPanel implements MouseListener, KeyListener, MouseMotionListener {
    private int rectX, rectY, width, height;
    private ArrayList<ColoredRectangle> myRects;
    private boolean[] keys;
    private Rectangle outline;
    private Timer t;
    private int cooldown;
    private Color color;
    private Point lankySpawn;
    private Point squatSpawn;
    private Point goal;
    private int drawMode;



    public LevelEditor() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        keys = new boolean[1000];
        outline = new Rectangle();
        myRects = new ArrayList<ColoredRectangle>();
        color = Color.black;
        drawMode = 0;
        lankySpawn = new Point(1400,30);
        squatSpawn = new Point(1400,40);
        goal = new Point(1400,50);

        for(int i = 10; i<1441; i=i+10){
        }

        t = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isKeyPressed(KeyEvent.VK_SPACE)) {
                    for (int i = 0; i<myRects.size();i++) {
                        if (rectContains(myRects.get(i), (int) MouseInfo.getPointerInfo().getLocation().getX() - 720, -(int) MouseInfo.getPointerInfo().getLocation().getY() + 470)) {
                            myRects.remove(i);
                            i--;
                            repaint();
                        }
                    }
                }
                if(isKeyPressed(KeyEvent.VK_BACK_SPACE)){
                    if(myRects.size()>0 && cooldown==0) {
                        myRects.remove(myRects.size() - 1);
                        cooldown=50;
                        repaint();
                    }
                }
                if(cooldown>0){
                    cooldown--;
                }
                if(isKeyPressed(KeyEvent.VK_1)){
                    color = Color.black;
                    repaint();
                }
                if(isKeyPressed(KeyEvent.VK_2)){
                    color = Color.red;
                    repaint();
                }
                if(isKeyPressed(KeyEvent.VK_3)){
                    color = Color.blue;
                    repaint();
                }
                if(isKeyPressed(KeyEvent.VK_S) && cooldown==0){
                    LevelController lc = new LevelController();
                    lc.writeLevel(myRects);
                    cooldown=50;
                }
                if(isKeyPressed(KeyEvent.VK_UP) && cooldown==0){
                    if (drawMode<3){
                        drawMode++;
                    }
                    else{
                        drawMode = 0;
                    }
                    cooldown=25;
                    repaint();
                }

            }
        });

        t.start();
    }

    public static void main(String[] args) {


        JFrame window = new JFrame("Conway\'s Game of Life");
        window.setDefaultCloseOperation(3);
        window.setBounds(0, 0, 1440, 850);
        LevelEditor panel = new LevelEditor();
        panel.grabFocus();
        panel.setFocusable(true);
        window.add(panel);
        window.setVisible(true);


    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
        AffineTransform move = AffineTransform.getTranslateInstance(720, -425);
        g2.transform(yFlip);
        g2.transform(move);


        for (int i = 0; i < myRects.size();i++) {
            g2.setColor(myRects.get(i).getColor());
            g2.fill(myRects.get(i));
        }
        g2.setColor(color);
        g2.draw(outline);

        g2.setColor(Color.orange);
        g2.fillRect((int)lankySpawn.getX(),(int)lankySpawn.getY(),10,10);

        g2.setColor(Color.green);
        g2.fillRect((int)squatSpawn.getX(),(int)squatSpawn.getY(),10,10);

        g2.setColor(Color.pink);
        g2.fillRect((int)goal.getX(),(int)goal.getY(),10,10);

        if(drawMode == 0) {
            g2.setColor(color);
        }
        else if(drawMode==1){
            g2.setColor(Color.orange);
        }
        else if(drawMode==2){
            g2.setColor(Color.green);
        }
        else{
            g2.setColor(Color.pink);
        }

        g2.fillRect(700,380,20,20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(drawMode == 0) {
            rectX = round(e.getX() - 720);
            rectY = round(-e.getY() + 425);
        }
        else if(drawMode==1){
            lankySpawn.setLocation(e.getX() - 720,-e.getY() + 425);
            repaint();

        }
        else if(drawMode==2){
            squatSpawn.setLocation(e.getX() - 720,-e.getY() + 425);
            repaint();
        }
        else{
            goal.setLocation(e.getX() - 720,-e.getY() + 425);
            repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(drawMode == 0) {
            width = round(e.getX() - rectX - 720);
            height = round(-e.getY() + 425 - rectY);
            myRects.add(new ColoredRectangle(rectX, rectY, width, height, color));
            outline.setSize(-1, -1);
            repaint();
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean isKeyPressed(int code) {
        return keys[code];
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

    @Override
    public void mouseDragged(MouseEvent e) {
        if(drawMode == 0) {
            width = round(e.getX() - rectX - 720);
            height = round(-e.getY() + 425 - rectY);
            outline.setBounds(rectX, rectY, width, height);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private static int round(int n) {
        return (n + 9)/10 * 10;
    }

    private boolean rectContains(Rectangle rect, int x, int y) {
        if (rect.getX() < x && rect.getWidth() + rect.getX() > x) {
            if (rect.getY() < y && rect.getY() + rect.getHeight() > y) {
                return true;
            }
        }
        return false;
    }
}
