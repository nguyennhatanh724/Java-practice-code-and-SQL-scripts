import java.util.Scanner;

public class B2 {
    public static boolean isPalindromeFlexible(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char L = s.charAt(i), R = s.charAt(j);
            if (!Character.isLetterOrDigit(L)) { i++; continue; }
            if (!Character.isLetterOrDigit(R)) { j--; continue; }
            if (Character.toLowerCase(L) != Character.toLowerCase(R)) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.println(isPalindromeFlexible(str) ? "PALINDROME" : "NOT PALINDROME");
    }
}
