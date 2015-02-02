import java.io.*;

/**
 * Created by PierreM on 02/02/2015.
 */
public class BinaryCopyFiles {
    public static void main(String[] args) {
        BinaryCopyFiles programme = new BinaryCopyFiles();
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
            BufferedInputStream in = null;
            BufferedOutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(fileIn));
                out = new BufferedOutputStream(new FileOutputStream(fileOut));
                int byteTemp;
                while ((byteTemp = in.read()) != -1) {
                    out.write(byteTemp);
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
