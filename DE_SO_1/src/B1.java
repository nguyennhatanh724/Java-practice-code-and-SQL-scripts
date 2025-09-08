import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter a String:");
        String str = "";

        while (true) {
            str = input.nextLine();
            if(!(str == null) && !(str.equals(" ")) && !str.trim().isEmpty()) {
                break;
            }
        }

        input.close();

        System.out.println("Your entered: " + str.toUpperCase().trim());
    }
}
