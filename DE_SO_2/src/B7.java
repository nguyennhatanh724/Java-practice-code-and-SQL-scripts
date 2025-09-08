import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B7 {
    private static Pattern WORD = Pattern.compile("\\p{L}[\\p{L}\\p{Nd}’']*");
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> word = new HashMap<>();

        System.out.println("Please enter  a sentence: ");
        String sentence = input.nextLine();
        Matcher matcher = WORD.matcher(sentence.toLowerCase(Locale.ROOT));

        while (matcher.find()) {
            String word1 = matcher.group();
            word.merge(word1, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(word.entrySet());
        list.sort((a, b) -> {
            int c = Integer.compare(b.getValue(), a.getValue());
            return (c != 0) ? c : a.getKey().compareTo(b.getKey());
        });

        for (var e : list) {
            System.out.printf("%-20s : %d%n", e.getKey(), e.getValue());
        }
    }
}
