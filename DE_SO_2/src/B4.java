import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B4 {
    public static String ReverseWord(String str) {
        if(str == null || str.isEmpty()){
            return null;
        }
        String[] parts = str.trim().split("\\s+");
        Collections.reverse(Arrays.asList(parts));
        return String.join(" ", parts);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = input.nextLine();
        System.out.println("Reversed sentence: " + ReverseWord(sentence));
    }
}
