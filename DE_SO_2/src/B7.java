import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Console program that count the frequency of each word in a sentence
 * and prints the result sorted by frequency (descending)
 */
public class B7 {
    // Regex pattern to match words (letters followed by letters, digits, apostrophes)
    private static Pattern WORD = Pattern.compile("\\p{L}[\\p{L}\\p{Nd}’']*");

    /**
     * Entry point of the program
     * Read a sentence from user, counts word frequency,
     * sorts them by frequency and alphabet, and prints the result.
     *
     * @param args (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> word = new HashMap<>();

        System.out.println("Please enter  a sentence: ");
        String sentence = input.nextLine();
        //Match word in the sentence using regex
        Matcher matcher = WORD.matcher(sentence.toLowerCase(Locale.ROOT));

        //Count word frequencies
        while (matcher.find()) {
            String word1 = matcher.group();
            word.merge(word1, 1, Integer::sum);
        }
        //Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> list = new ArrayList<>(word.entrySet());

        //Sort: by frequency descending, then alphabetically ascending
        list.sort((a, b) -> {
            int c = Integer.compare(b.getValue(), a.getValue());
            return (c != 0) ? c : a.getKey().compareTo(b.getKey());
        });
        //Print the sorted list
        for (var e : list) {
            System.out.printf("%-20s : %d%n", e.getKey(), e.getValue());
        }
    }
}
