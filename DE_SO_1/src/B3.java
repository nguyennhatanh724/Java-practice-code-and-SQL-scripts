import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer max = null;
        Integer min = null;
        Long sum = 0L;

        System.out.println("Enter the elements ( type (stop) to finish: ");
        while(true) {
            String check = input.nextLine();
            if ( check.equals("stop") ) {
                break;
            }
            try {
                Integer value = Integer.parseInt(check);
                list.add(value);
                sum += value;
                if(max == null ||max < value){ max = value;}
                if(min == null ||min > value){ min = value;}
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        double avg = (double) sum/ list.size();

        System.out.println(min + " " + max + " " + avg);


    }
}
