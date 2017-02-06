import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by simon_clark on 1/20/17.
 */
public class LevelController {

    private ArrayList<Level> levels;

    public ArrayList<GameObject> readLevel(int level) {

        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader("level/" + Integer.toString(level) + ".txt"));

            String in = fileReader.readLine();

            while (in != null) {
                System.out.println(in);
                in = fileReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("File " + " nonresponding");
        }

        return null;
    }

    private void parseLine(String in, int levelIndex){

    }
}