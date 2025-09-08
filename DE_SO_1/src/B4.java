import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the name of the student you want to add, type 'stop' to finish: ");
        String token = null;
        while(true){
            token = input.nextLine();
            if((token.trim().toLowerCase().equals("stop"))) break;
            students.add(token);
        }
        Collections.sort(students);
        for(String s : students){
            System.out.println(s);
        }

    }
}
