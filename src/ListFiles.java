import java.io.File;

/**
 * Created by Pierre on 31/01/2015.
 */
public class ListFiles {
    public static void main(String[] args) {
        ListFiles programme = new ListFiles();
        programme.launch();
    }

    public void launch() {
        String directoryName = ".";
        File file = new File(directoryName);
        File[] list = file.listFiles();
        int i = 0;
        while (i < list.length) {
            if (list[i].isDirectory())
                System.out.println("Directory: " + list[i].getAbsolutePath());
            if (list[i].isFile())
                System.out.println("File: " + list[i].getName());
            i++;
        }
    }
}
