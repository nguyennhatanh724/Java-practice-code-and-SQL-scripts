import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String index;
        int sum = 0;

        System.out.println("Enter an integer: ");

        while (true) {
            try {
                index = input.nextLine();
                int value = Integer.parseInt(index);
                for (int i = 0; i < index.length(); i++) {
                    sum += (index.charAt(i) - '0');
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

        System.out.println("the sum is " + sum);

    }
}
