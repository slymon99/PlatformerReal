import java.awt.*;

/**
 * Created by Simon on 12/3/2016.
 */
public class Block{
    
    private int x, y, w, h;
    

    public Block(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2){
        g2.fillRect(x,y,w,h);
    }


    public void moveX(int delta){
        x+=delta;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
