import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LexicalTwistPuzzle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        String combined = (word1 + word2).toUpperCase();

        int vowels = 0;
        int consonants = 0;

        for (char ch : combined.toCharArray()) {

            if ("AEIOU".indexOf(ch) != -1) vowels++;
            else if (Character.isLetter(ch)) consonants++;
        }

        Set<Character> unique = new LinkedHashSet<>();
        for (char ch : combined.toCharArray()) {
            if (Character.isLetter(ch))
                unique.add(ch);
        }

        if (vowels > consonants) {
            printFirstTwo(unique, true);
        } else if (consonants > vowels) {
            printFirstTwo(unique, false);
        } else {
            System.out.println("Vowels and consonants are equal");
        }
    }

    private static void printFirstTwo(Set<Character> set, boolean vowelMode) {

        int count = 0;

        for (char ch : set) {

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