import java.util.BitSet;
import java.util.Scanner;

/**
 * Console program to check if a given sentence is a pangram
 * (a sentence that contains every letter of the English alphabet at least once).
 */
public class B6 {
    /**
     * Checks if a given string is a pangram
     * Letter are normalized to lowercase before checking
     *
     * @param s the input value to check
     * @return true if the input value is a pangram, false otherwise
     */
    public static boolean isPangram(String s) {
        //Use BitSet to track which letters have been seen
        BitSet bitSet = new BitSet(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //Convert uppercase letters to lowercase
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                ch = (char) (s.charAt(i) - 'A' + 'a');
            }

            //If character is a lowercase letter, mark it as seen
            if (ch >= 'a' && ch <= 'z') {
                bitSet.set(s.charAt(i) - 'a');
            }

            //If all 26 letters are found, mark it is a pangram
            if (bitSet.cardinality() == 26) {
                return true;
            }
        }

        //Not all 26 letters were found
        return false;
    }

    /**
     * Entry point of the application
     * Reads lines from user input and checks whether each line is a pangram
     * Stops when the user enters a blank line
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");

        while (true) {
            String line = scanner.nextLine();

            //Stop if the line is blank
            if (line.isBlank()) break;

            boolean ok = isPangram(line);
            System.out.println(ok ? "PANGRAM" : "NOT PANGRAM");
            System.out.println();
        }
        scanner.close();

    }
}
