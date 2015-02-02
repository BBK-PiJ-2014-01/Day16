import java.io.*;

/**
 * Created by PierreM on 31/01/2015.
 */
public class CopyFiles {
    public static void main(String[] args) {
        CopyFiles programme = new CopyFiles();
        programme.launch(args);
    }

    public void launch(String[] args) {
        if (args.length == 0) {
            System.out.println("No argument found");
        } else {
            String fileNameIn = args[0];
            String fileNameOut = args[1];
            File fileIn = new File(fileNameIn);
            File fileOut = new File(fileNameOut);
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new FileReader(fileIn));
                out = new PrintWriter(fileOut);
                String line;
                while ((line = in.readLine()) != null) {
                    out.write(line+"\n");
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Sorry, file not found");
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (in != null)
                        in.close();
                    if (out != null)
                        out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
