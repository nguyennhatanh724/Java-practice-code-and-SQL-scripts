import java.util.Scanner;

public class B4 {
    public static boolean hasDigit(String str){
        if(str == null){
            return false;
        }
        for(int a = 0; a < str.length(); a++){
            if((str.charAt(a) >= '0') && (str.charAt(a) <= '9')){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String chars;

        while (true) {
            System.out.print("Enter a string: ");
            chars = input.nextLine();
            if (!chars.isBlank()) break;
        }

        System.out.println(hasDigit(chars)? "YES" : "NO");
    }
}
