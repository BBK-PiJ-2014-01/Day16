import java.io.*;

/**
 * Created by PierreM on 02/02/2015.
 */
public class Translate {
    public static void main(String[] args) {
        Translate programme = new Translate();
        programme.launch(args);
    }

    public void launch(String[] args) {
        String fileName = "";
        String stringBefore = "";
        String stringAfter = "";
        File file = null;
        BufferedReader in = null;
        try {
            fileName = args[0];
            stringBefore = args[1];
            stringAfter = args[2];
            file = new File(fileName);
            in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String newLine = line.replace(stringBefore, stringAfter);
                System.out.println(newLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, file not found");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Sorry, wrong number of arguments");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
