import java.io.File;

/**
 * Created by Pierre on 31/01/2015.
 */
public class Mkdir {
    public static void main(String[] args) {
        Mkdir programme = new Mkdir();
        programme.launch(args);
    }

    public void launch(String[] args) {
        boolean success = false;
        String directoryName = "./";
        try {
            if (args.length != 1)
                throw new IndexOutOfBoundsException();
            directoryName += args[0];
            File file = new File(directoryName);
            success = file.mkdir();
            if (success)
                System.out.println("Directory created");
            else
                System.out.println("Directory not created");
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("Input problem!");
        }

    }
}
