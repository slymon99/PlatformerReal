import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by simon_clark on 1/20/17.
 */
public class LevelController {

    private ArrayList<Level> levels;

    private int nextLevel;

    public LevelController(){
        nextLevel = 0;
    }

    public ArrayList<GameObject> readLevel(int level) {

        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader("level/" + Integer.toString(level) + ".txt"));

            String in = fileReader.readLine();

            while (in != null) {
                parseLine(in);
                in = fileReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("File " + " nonresponding");
        }

        return null;

    }

    public void writeLevel(ArrayList<ColoredRectangle> rects) {


        BufferedWriter bw = null;
        FileWriter fw = null;


            try {
                PrintWriter writer = new PrintWriter("level/" + Integer.toString(nextLevel)+ ".txt", "UTF-8");

                for (ColoredRectangle rect : rects) {
                    writer.println(rect.encodeString());
                }

                writer.close();
            } catch (IOException e) {
                // do something
            }

            nextLevel++;

    }

    private Level parseLine(String in) {
        Level l = new Level();

        String[] line = in.split(" ");
        if (line[0] == "m") {

        }

        if (line[0] == "p") {

        }
        return null;
    }
}