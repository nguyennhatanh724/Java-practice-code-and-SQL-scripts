import java.util.InputMismatchException;
import java.util.Scanner;

public class B1 {
    public static void fibonacci(int n) {
        if (n < 1) {
            System.out.println("Invalid input");
            return;
        }
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + (i < n - 1 ? " " : "\n"));
            long next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n (>= 1): ");
        while (true) {
            try{
                int n = input.nextInt();
                fibonacci(n);
                break;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                input.next();
            }
        }
    }
}
