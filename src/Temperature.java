import java.io.*;

/**
 * Created by Pierre on 01/02/2015.
 */
public class Temperature {
    public static void main(String[] args) {
        Temperature t = new Temperature();
        t.launch();
    }

    public void launch() {

        File file = new File("C:/Users/Pierre/IdeaProjects/Day16/src/input.csv");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line;
            double fileSum = 0;
            double fileCount = 0;
            double fileAverage = 0;
            while ((line = in.readLine()) != null) {
                double lineSum = 0;
                double lineCount = 0;
                double lineAverage = 0;
                String[] item = line.split(", ");
                for (int i = 0; i < item.length; i++) {
                    lineSum += Integer.parseInt(item[i]);
                    lineCount++;
                }
                System.out.println(lineSum+" "+lineCount);
                lineAverage = lineSum/lineCount;
                System.out.println("Line average: "+lineAverage);
                fileSum += lineSum;
                fileCount += lineCount;
            }
            fileAverage = fileSum/fileCount;
            System.out.println("\nFile average: "+fileAverage);
        } catch (FileNotFoundException ex) {
            System.out.println("File " + file + " does not exist.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeReader(in);
        }
    }

    private void closeReader(Reader reader) {
        try {
            if (reader != null)
                reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
