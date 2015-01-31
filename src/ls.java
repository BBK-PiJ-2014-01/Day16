import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Pierre on 31/01/2015.
 */
public class ls {
    public static void main(String[] args) {
        ls programme = new ls();
        programme.launch();
    }

    public void launch() {
        String filename = ".";
        File file = new File(filename);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException ex) {
            System.out.println("File does not exist");
        }
        System.out.println(file.list());
        in.close;
    }
}
