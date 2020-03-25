public class Application {
    public static void main(String[] args) {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        String dataFile = "text_files/problem2.txt";
        String outputFile = "text_files/unique_words.txt";

        duplicateCounter.count(dataFile);
        duplicateCounter.write(outputFile);
    }

}
