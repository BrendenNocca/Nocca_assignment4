public class Application {
    public static void main(String[] agrs) {

        String dataFile = "text_files/problem1.txt";
        String outputFile = "text_files/unique_words.txt";


        DuplicateRemover duplicateRemover = new DuplicateRemover();
        duplicateRemover.remove(dataFile);
        duplicateRemover.write(outputFile);
    }

}

