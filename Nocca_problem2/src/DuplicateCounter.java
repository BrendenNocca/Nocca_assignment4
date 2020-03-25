import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {
       public  Map<String, String> wordCount = new HashMap<>();
       public ArrayList<String> uniqueWords = new ArrayList<>();


    public DuplicateCounter() {

    }

    public void count(String dataFile) {
        try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = " ";


            while (true) {

                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] Words = line.split(" ");
                for (int n = 0; n < Words.length; n++) {
                    uniqueWords.add(Words[n]);

                }
            }

            for (int i = 0; i < uniqueWords.size(); i++) {
                int WordCount = 1;
                for (int k = i+1; k < uniqueWords.size(); k++) {
                    if (uniqueWords.get(i).equals(uniqueWords.get(k))) {
                        uniqueWords.remove(k);
                        k--;
                        WordCount++;
                    }
                }
                String StringWordCount = Integer.toString(WordCount);
                wordCount.put(uniqueWords.get(i), StringWordCount);
            }


        } catch (FileNotFoundException e) {
            System.out.println("The file you specified was not found in the path provided");
        } catch (Exception e) {
            System.out.println("The text file provided was not able to be read by the program");
        }

    }

    public void write(String outputFile){
        try {
            FileWriter writer = new FileWriter(outputFile);
            for(int i = 0; i<uniqueWords.size();i++){
                writer.write("The Word "+uniqueWords.get(i)+" Occurs "+wordCount.get(uniqueWords.get(i))+" Times\n");
            }
            writer.close();


        } catch (FileNotFoundException e) {
            System.out.println("The file you specified was not found in the path provided");
        }catch (Exception e){
            System.out.println("The new file path was not able to be determined");
        }

    }

}