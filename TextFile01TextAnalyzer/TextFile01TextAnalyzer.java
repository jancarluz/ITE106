import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TextFile01TextAnalyzer {
    public static void main(String[] args) {
        String fileName = "Help.txt";
        StringBuilder textContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textContent.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        String text = textContent.toString().trim();

        String[] words = text.split("\\s+");
        int wordCount = words.length;

        int sentenceCount = text.split("[.!?]").length;

        String upperCaseText = text.toUpperCase();

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Sentences: " + sentenceCount);
        System.out.println("Uppercase Text:\n" + upperCaseText);
        System.out.println("Longest Word: " + longestWord);
    }
}
