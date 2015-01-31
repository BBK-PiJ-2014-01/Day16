import java.io.File;

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
        System.out.println(file.list());
    }
}
