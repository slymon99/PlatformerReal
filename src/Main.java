import javax.swing.*;
import java.awt.*;

/**
 * Created by Simon on 12/3/2016.
 */
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Platform");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 600); //(x, y, w, h)
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setFocusable(true);
        gamePanel.grabFocus();

        window.add(gamePanel);
        window.setVisible(true);

        gamePanel.start();




//        window.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // before we stop the JVM stop the example
//                super.windowClosing(e);
//            }
//        });

//        window.
//
//        Window panel = new Window();
//        panel.setFocusable(true);
//
//        window.add(panel);
//        window.setVisible(true);
    }


}
