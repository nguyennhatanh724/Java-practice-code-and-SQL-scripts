import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String chars;

        System.out.println("Enter number of characters: ");
        chars = input.nextLine();
        int count = 0;

        for(int i = 0; i < chars.length(); i++){
            if( ( (chars.charAt(i)<= 'z')&&(chars.charAt(i)>= 'a') || (chars.charAt(i)<= 'Z')&&(chars.charAt(i)>= 'A') ) ){ count++; }
        }

        System.out.println("Number of characters in " + chars + " is " + count);
    }
}
