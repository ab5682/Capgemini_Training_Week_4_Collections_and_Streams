import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void countWordFrequency(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        Map<String, Integer> wordCount = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("[^a-zA-Z]+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();
        
        System.out.println(wordCount);
    }

    public static void main(String[] args) throws IOException {
        String fileName = "sample.txt";  
        countWordFrequency(fileName);
    }
}
