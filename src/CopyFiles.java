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
        File directory = new File(args[args.length-1]);
        if (!directory.isDirectory())
            System.out.println("Sorry, the last name does not correspond to a directory");
        else {
            int i=0;
            while (i<args.length-1) {
                String fileNameIn = args[i];
                String fileNameOut = directory.getAbsolutePath()+File.separator+args[i];
                System.out.println(fileNameOut);
                File fileIn = new File(fileNameIn);
                File fileOut = new File(fileNameOut);
                BufferedReader in = null;
                PrintWriter out = null;
                try {
                    in = new BufferedReader(new FileReader(fileIn));
                    out = new PrintWriter(fileOut);
                    String line;
                    while ((line = in.readLine()) != null) {
                        out.write(line + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Sorry, file not found");
                    ex.printStackTrace();
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
                i++;
            }
        }
    }
}
