import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PierreM on 02/02/2015.
 */
public class Sort {
    public static void main(String[] args) {
        Sort programme = new Sort();
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
            List<String> newList = quickSort(list);
            for (int i=0;i<newList.size();i++)
                System.out.println(newList.get(i));
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

    public static List<String> quickSort(List<String> unsortedList) {
        List<String> resultList = new LinkedList<String>();
        if (unsortedList.size() < 2)
            return(unsortedList);
        else {
            List<String> lowList = new LinkedList<String>();
            List<String> highList = new LinkedList<String>();
            String pivot = unsortedList.get(0);
            for (int i=1; i<unsortedList.size(); i++) {
                if (unsortedList.get(i).compareTo(pivot) < 0)
                    lowList.add(unsortedList.get(i));
                else
                    highList.add(unsortedList.get(i));
            }
            List<String> sortedLowList = quickSort(lowList);
            List<String> sortedHighList = quickSort(highList);
            while (!sortedLowList.isEmpty()) {
                resultList.add(sortedLowList.get(0));
                sortedLowList.remove(0);
            }
            resultList.add(pivot);
            while (!sortedHighList.isEmpty()) {
                resultList.add(sortedHighList.get(0));
                sortedHighList.remove(0);
            }
            return(resultList);
        }
    }

}
