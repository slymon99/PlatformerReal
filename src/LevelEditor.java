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
    private ArrayList<Rectangle> myRects;
    private boolean[] keys;
    private Rectangle outline;
    private Timer t;
    private int mouseX, mouseY;
    private int recentlyDeleted;


    public LevelEditor() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        keys = new boolean[1000];
        outline = new Rectangle();
        myRects = new ArrayList<Rectangle>();

        myRects.add(new Rectangle(200, 300, 40, 40));

        t = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(MouseInfo.getPointerInfo().getLocation().getX() + " pls");
                if (isKeyPressed(KeyEvent.VK_SPACE)) {
                    System.out.println("space");
                    for (int i = 0; i<myRects.size();i++) {
                        if (rectContains(myRects.get(i), (int) MouseInfo.getPointerInfo().getLocation().getX() - 720, -(int) MouseInfo.getPointerInfo().getLocation().getY() + 425)) {
                            myRects.remove(i);
                            i--;
                            repaint();
                        }
                    }
                }
                if(isKeyPressed(KeyEvent.VK_BACK_SPACE)){
                    if(myRects.size()>0 && recentlyDeleted==0) {
                        myRects.remove(myRects.size() - 1);
                        recentlyDeleted=50;
                        repaint();
                    }
                }
                if(recentlyDeleted>0){
                    recentlyDeleted--;
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


        for (Rectangle r : myRects) {
            g2.fill(r);
        }
        g2.draw(outline);
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        rectX = e.getX() - 720;
        rectY = -e.getY() + 425;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        width = e.getX() - rectX - 720;
        height = -e.getY() + 425 - rectY;
        myRects.add(new Rectangle(rectX, rectY, width, height));
        repaint();


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
        width = e.getX() - rectX - 720;
        height = -e.getY() + 425 - rectY;
        outline.setBounds(rectX, rectY, width, height);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
//        System.out.println(mouseX + " " + mouseY);
    }

    private int round(int n) {
        return (n / 10) * 10;
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
