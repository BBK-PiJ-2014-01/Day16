import java.io.*;
import java.util.LinkedList;
import java.util.List;

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
        List<String> list = new LinkedList<String>();
        try {
            fileName = args[0];
            file = new File(fileName);
            in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
            List<String> newList = Sort.quickSort(list);
            String buffer = "";
            for (int i=0;i<newList.size();i++) {
                if (i==0) {
                    buffer = newList.get(0);
                    System.out.println(buffer);
                } else {
                    if (newList.get(i).compareTo(buffer) == 0) {
                        i++;
                    } else {
                        System.out.println(newList.get(i));
                        buffer = newList.get(i);
                    }
                }
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
