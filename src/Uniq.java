import java.io.*;

/**
 * Created by PierreM on 02/02/2015.
 */
public class Uniq {
    public static void main(String[] args) {
        Uniq programme = new Uniq();
        programme.launch(args);
    }

    public void launch(String[] args) {
        String fileName = "";
        File file = null;
        BufferedReader in = null;
        try {
            fileName = args[0];
            file = new File(fileName);
            in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                //
                //System.out.println(newLine);
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

}
