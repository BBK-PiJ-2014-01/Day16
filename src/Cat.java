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
        String fileName = "";
        BufferedReader in = null;
        try {
            if (args.length == 0)
                throw new IndexOutOfBoundsException();
            fileName += args[0];
            File file = new File(fileName);
            in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(FileNotFoundException ex) {
            System.out.println("File "+args[0]+" not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeReader(in);
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
