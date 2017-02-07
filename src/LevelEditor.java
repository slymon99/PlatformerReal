import org.dyn4j.geometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * Created by simon_clark on 1/23/17.
 */
public class LevelEditor extends JPanel  implements MouseListener{
    private int rectX, rectY, width, height;
    private ArrayList<Rectangle> myRects;


    public LevelEditor(){
        addMouseListener(this);
        myRects = new ArrayList<Rectangle>();

        myRects.add(new Rectangle(200,300, 40, 40));
    }

    public static void main(String[] args) {


        JFrame window = new JFrame("Conway\'s Game of Life");
        window.setDefaultCloseOperation(3);
        window.setBounds(0, 0, 1440, 850);
        LevelEditor panel = new LevelEditor();
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
        AffineTransform move = AffineTransform.getTranslateInstance(720, -425);
        g2.transform(yFlip);
        g2.transform(move);



        for(Rectangle r: myRects) {
            g2.fill(r);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        rectX=e.getX()-720;
        rectY=-e.getY()+425;

        System.out.println(e.getX() + " " + rectX);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        width=e.getX()-rectX-720;
        height= -(e.getY()-rectY)+425;
        myRects.add(new Rectangle(rectX, rectY, width, height));
        repaint();


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
