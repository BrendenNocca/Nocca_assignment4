public class Application {
    public static void main(String[] args) {
        DuplicateCounter me = new DuplicateCounter();

        String dataFile = "text_files/problem2.txt";
        String outputFile = "text_files/unique_words.txt";

        me.count(dataFile);
        me.write(outputFile);
    }

}
