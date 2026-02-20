import java.util.Scanner;

public class LexicalTwistPuzzle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Lexical Twist Puzzle");

        System.out.print("Enter first word: ");
        String word1 = sc.nextLine();

        System.out.print("Enter second word: ");
        String word2 = sc.nextLine();

        if (!WordValidator.isValid(word1) || !WordValidator.isValid(word2)) {
            System.out.println("Invalid input detected");
            return;
        }

        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        analyzer.process(word1, word2);
    }
}