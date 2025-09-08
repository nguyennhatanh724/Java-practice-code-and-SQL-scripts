import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        boolean flag = true;

        System.out.println("Please enter an integer: ");
        n = input.nextInt();
            for(int i = 2; i < (n / 2 + 1); i++){
                if(n % i == 0){
                    flag = false;
                }
            }
            if(flag){
                System.out.println("true");
            }else       {
                System.out.println("false");
            }
    }
}
