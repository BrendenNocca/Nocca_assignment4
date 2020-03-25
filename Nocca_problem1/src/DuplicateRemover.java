import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class DuplicateRemover {
    public int placeHolder = 0;
    public ArrayList<String> uniqueWords = new ArrayList<String>();
    int c = 0;
    int[][] lineWordLength = new int[100][100];

    public DuplicateRemover() {

    }

    public void remove(String dataFile) {

        try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> uniqueWords = new ArrayList<String>();
            String line = " ";

            while (true) {

                line = bufferedReader.readLine();
                //breaks down the lines into words and then sorts them into an array
                if (line == null) {
                    break;
                }
                String[] Words = line.split(" ");
                for (int n = 0; n < Words.length; n++) {
                    uniqueWords.add(Words[n]);

                    if (line == null) {
                        uniqueWords.remove(uniqueWords.size() - 1);

                    }
                }
                //actually removes the extra words
                for (int i = 0; i < uniqueWords.size(); i++) {
                    for (int k = i + 1; k < uniqueWords.size(); k++) {
                        if (uniqueWords.get(i).equals(uniqueWords.get(k))) {
                            uniqueWords.remove(k);
                            k--;
                        }
                        lineWordLength[c][c] = k;
                    }
                }
                c++;
            }
            this.uniqueWords = uniqueWords;

            //need to change catches
        } catch (FileNotFoundException ex) {
            System.out.println("The file you specified was not found in the path provided");
        } catch (Exception e) {
            System.out.println("The text file provided was not able to be read by the program");
        }

    }

    public void write(String outputFile) {

        try {
            FileWriter writer = new FileWriter(outputFile);

            for (int f = 0; f < c; f++) {
                for (int j = placeHolder; j <= lineWordLength[f][f]; j++) {
                    writer.write(uniqueWords.get(j) + " ");
                }
                if (placeHolder == 0) {
                    placeHolder = placeHolder + lineWordLength[f][f] + 1;
                } else {
                    placeHolder = placeHolder + lineWordLength[f][f];
                }
                writer.write("\n");
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("The file you specified was not found in the path provided");
            } catch (Exception e){
            System.out.println("The new file path was not able to be determined");
            }
        }
    }