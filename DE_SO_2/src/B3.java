import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String token;

        System.out.println("Please enter a list of integers: ");

        while(true){
            token = input.nextLine();
            if(token.toLowerCase().equals("stop")){
                break;
            }
            try{
                list.add(Integer.parseInt(token));
            }catch(NumberFormatException e){
                System.out.println("Invalid input");
            }
        }
        for(int a = 0; a < list.size(); a++){
            if(list.get(a) % 2 == 0){
                System.out.println(list.get(a));
            }
        }
    }
}
