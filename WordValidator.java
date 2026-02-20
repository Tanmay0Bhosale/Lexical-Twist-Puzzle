public class WordValidator {

    public static boolean isValid(String word) {
        return !word.contains(" ") && word.length() > 0;
    }
}