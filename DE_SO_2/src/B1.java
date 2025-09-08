import java.util.InputMismatchException;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        while (true){
            System.out.println("Please enter an integer: ");
            try{
                n = input.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                input.next();
            }
        }
        for(int i = 0; i <= 10; i++){
            System.out.println(i + " x " + n + " = " + (i * n));
        }
    }
}
