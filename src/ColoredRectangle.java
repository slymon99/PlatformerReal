import java.awt.*;

/**
 * Created by simon_clark on 3/2/17.
 */
public class ColoredRectangle extends Rectangle{
    private Color color;

    public ColoredRectangle(int x, int y, int w, int h, Color c){
        super(x,y,w,h);
        color = c;
    }
    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
