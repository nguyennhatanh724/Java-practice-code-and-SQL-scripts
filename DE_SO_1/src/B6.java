import java.util.BitSet;
import java.util.Scanner;

public class B6 {
    public static boolean isPangram(String s) {
        BitSet bitSet = new BitSet(s.length());
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                ch = (char)(s.charAt(i) - 'A' + 'a');
            }
            if(ch >= 'a' && ch <= 'z'){
                bitSet.set(s.charAt(i) - 'a');
            }
            if(bitSet.cardinality() == 26){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        while (true) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            boolean ok = isPangram(line);
            System.out.println(ok ? "PANGRAM" : "NOT PANGRAM");
            System.out.println();
        }
        scanner.close();

    }
}
