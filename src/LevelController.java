import java.io.*;
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
                parseLine(in);
                in = fileReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("File " + " nonresponding");
        }

        return null;
    }

    public void writeLevel() {


        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "This is the content to write into file\n";

            fw = new FileWriter("level/testFile.txt");
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
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