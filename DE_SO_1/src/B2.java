import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        while (true) {
            try {
                System.out.println("Enter an integer n :");
                n = input.nextInt();
                char sign = '+';
                if (n < 0) {
                    sign = '-';
                    System.out.printf("1 ");
                }
                for (int i = 1; i <= Math.abs(n); i++) {
                    if (i % 2 == 1) System.out.printf("%c%d ", sign, i);
                }
                break;
            } catch (Exception e) {
                System.out.println("err" + e.getMessage());
                input.nextLine();
            }
        }
        input.close();
    }
}
