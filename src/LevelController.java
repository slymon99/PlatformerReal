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

    public Level readLevel(int levelNum) {
        System.out.println("reading level...");

        ArrayList<GameObject> levelObjects = new ArrayList<GameObject>();

        BufferedReader fileReader;

        Point s = new Point();
        Point l = new Point();
        Point g = new Point();

        try {
            fileReader = new BufferedReader(new FileReader("level/" + Integer.toString(levelNum) + ".txt"));

            String in = fileReader.readLine();

            s = parseInfo(in);
            in = fileReader.readLine();

            l = parseInfo(in);
            in = fileReader.readLine();

            g = parseInfo(in);
            in = fileReader.readLine();


            while (in != null) {
                levelObjects.add(parsePlatform(in));
                in = fileReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("File " + "nonresponding");
            e.printStackTrace();
        }


        Level levelToReturn = new Level(levelObjects);
        levelToReturn.setInfo(s, l, g);

        return (levelToReturn);
    }

    public void writeLevel(ArrayList<ColoredRectangle> rects, Point lankySpawn, Point squatSpawn, Point goal) {

        try {
            PrintWriter writer = new PrintWriter("levelDrafts/" + Integer.toString(nextLevel) + ".txt", "UTF-8");


            writer.println("Squat " + squatSpawn.getX() / 15 + " " + squatSpawn.getY() / 15);
            writer.println("Lanky " + lankySpawn.getX() / 15 + " " + lankySpawn.getY() / 15);
            writer.println("Goal " + goal.getX() / 15 + " " + goal.getY() / 15);


            for (ColoredRectangle rect : rects) {
                writer.println(rect.encodeString());
            }


            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        nextLevel++;

    }

    private GameObject parsePlatform(String in) {
        String[] line = in.split(" ");

        double[] values = new double[line.length - 1];

        for (int j = 0; j < values.length; j++) {
            values[j] = Double.parseDouble(line[j + 1]);
        }

        if (line[0].equals("platform")) {
//            System.out.println("I loaded platform" + values[0]+ " " + values[1]+ " " + values[2] + " " + values[3] );
            return (new Platform(values[0], values[1], values[2], values[3]));

        }
        else if(line[0].equals("spikes")){
            return (new Lava(values[0], values[1], values[2], values[3]));
        }

        else {
            System.out.println("Error parsing line - unknown type \"" + line[0] + "\"");
            return null;
        }

    }

    private Point parseInfo(String in) {
        String[] line = in.split(" ");

        double[] values = new double[line.length - 1];

        for (int j = 0; j < values.length; j++) {
            values[j] = Double.parseDouble(line[j + 1]);
        }

        return (new Point((int) (values[0]), (int) (values[1])));
    }
}