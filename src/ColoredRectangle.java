import java.awt.*;

/**
 * Created by simon_clark on 3/2/17.
 */
public class ColoredRectangle extends Rectangle {
    private Color color;

    public ColoredRectangle(int x, int y, int w, int h, Color c) {
        super(x, y, w, h);
        color = c;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String encodeString() {
        String result = "";
        if (getColor().equals(Color.black)) {
            result += "platform";
        } else if (getColor().equals(Color.red)) {
            result += "spikes";
        } else if (getColor().equals(Color.black)) {
            result += "movingPlatform";
        }
        result += " " + getX()/15 + " " + getY()/15 + " " + getWidth()/15 + " " + getHeight()/15 + " ";


        return result;
    }
}
