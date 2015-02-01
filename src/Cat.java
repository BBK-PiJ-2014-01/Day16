import java.io.*;

/**
 * Created by Pierre on 31/01/2015.
 */
public class Cat {
    public static void main(String[] args) {
        Cat programme = new Cat();
        programme.launch(args);
    }

    public void launch(String[] args) {
        if ((args.length == 0)||(args.length>2)) {
            System.out.println("Wrong number of arguments found");
        } else {
            String fileName = "";
            BufferedReader in = null;
            int i = 0;
            while (i < args.length) {
                try {
                    fileName = args[i];
                    File file = new File(fileName);
                    in = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("\n");
                } catch (FileNotFoundException ex) {
                    System.out.println("File " + args[0] + " not found");
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    closeReader(in);
                }
                i++;
            }
        }
    }

    private void closeReader(Reader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
