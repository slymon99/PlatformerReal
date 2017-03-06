import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by simon_clark on 1/20/17.
 */
public class LevelController {

    private int nextLevel;

    public LevelController() {
        nextLevel = 0;
    }

    public ArrayList<GameObject> readLevel(int levelNum) {

        ArrayList<GameObject> level = new ArrayList<GameObject>();

        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader("level/" + Integer.toString(levelNum) + ".txt"));

            String in = fileReader.readLine();

            while (in != null) {
                level.add(parseLine(in));
                in = fileReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("File " + " nonresponding");
        }

        return level;

    }

    public void writeLevel(ArrayList<ColoredRectangle> rects) {

        try {
            PrintWriter writer = new PrintWriter("level/" + Integer.toString(nextLevel) + ".txt", "UTF-8");

            for (ColoredRectangle rect : rects) {
                writer.println(rect.encodeString());
            }

            writer.close();
        } catch (IOException e) {
            // do something
        }

        nextLevel++;

    }

    private GameObject parseLine(String in) {
        String[] line = in.split(" ");
        double[] values = new double[line.length-1];

        for (int j = 1; j < values.length; j++) {
            values[j] = Double.parseDouble(line[j+1]);
        }

        if (line[0].equals("platform")) {
            return(new Platform(values[0], values[1], values[2], values[3]));

        }
        else{
            System.out.println("Error parsing line - unknown type \"" + line[0] + "\"");
            return null;
        }

    }
}