import java.util.LinkedHashSet;
import java.util.Set;

public class LexicalAnalyzer {

    public void process(String word1, String word2) {

        if (isReverse(word1, word2)) {
            System.out.println(transform(word1));
        } else {
            analyze(word1, word2);
        }
    }

    private boolean isReverse(String w1, String w2) {
        String reversed = new StringBuilder(w1).reverse().toString();
        return reversed.equalsIgnoreCase(w2);
    }

    private String transform(String word) {

        return new StringBuilder(word)
                .reverse()
                .toString()
                .toLowerCase()
                .replaceAll("[aeiou]", "@");
    }

    private void analyze(String w1, String w2) {

        String combined = (w1 + w2).toUpperCase();

        int vowels = 0;
        int consonants = 0;

        for (char ch : combined.toCharArray()) {

            if ("AEIOU".indexOf(ch) != -1) vowels++;
            else if (Character.isLetter(ch)) consonants++;
        }

        if (vowels > consonants) {
            printUnique(combined, true);
        } else if (consonants > vowels) {
            printUnique(combined, false);
        } else {
            System.out.println("Vowels and consonants are equal");
        }
    }

    private void printUnique(String text, boolean vowelMode) {

        Set<Character> unique = new LinkedHashSet<>();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch))
                unique.add(ch);
        }

        int count = 0;

        for (char ch : unique) {

            if (vowelMode && "AEIOU".indexOf(ch) != -1) {
                System.out.print(ch);
                count++;
            }

            if (!vowelMode && "AEIOU".indexOf(ch) == -1) {
                System.out.print(ch);
                count++;
            }

            if (count == 2) break;
        }
    }
}