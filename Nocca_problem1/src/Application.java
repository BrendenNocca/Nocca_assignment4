public class Application {
    public static void main(String[] agrs) {

        String dataFile = "text_files/problem1.txt";
        String outputFile = "text_files/unique_words.txt";


        DuplicateRemover me = new DuplicateRemover();
        me.remove(dataFile);
        me.write(outputFile);
    }

}

