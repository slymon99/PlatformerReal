import javax.swing.*;
import java.awt.*;

/**
 * Created by simon_clark on 1/23/17.
 */
public class LevelEditor extends JPanel{
    public static void main(String[] args) {
        JFrame window = new JFrame("Conway\'s Game of Life");
        window.setDefaultCloseOperation(3);
        window.setBounds(0, 0, 800, 823);
        LevelEditor panel = new LevelEditor();
        window.add(panel);
        window.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.fillRect(10,10,10,10);
    }
}
