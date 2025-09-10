import java.util.*;

/**
 * Console program that generate 100 random integers from 1 to 100,
 * finds all unique multiples of 7, and prints them along with statistics
 */
public class B7 {
    /**
     * Entry point of the program.
     * Generates random numbers, collects multiples of 7 into a set (to remove duplicates),
     * and prints the original list, the set of multiples of 7, and their count.
     *
     * @param args (not used)
     */
    public static void main(String[] args) {
        Random rand = new Random();

        //Generate 100 random integers in range [1, 100]
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) {
            int x = rand.nextInt(100) + 1;
            list.add(x);
        }

        //Collect unique multiples of 7, and prints them along with statistics
        Set<Integer> set = new TreeSet<>();
        for( int a : list ) {
            if(a % 7 == 0){
                set.add(a);
            }
        }
        System.out.println("100 so ngau nhien: " + list);
        System.out.println("Bo 7 (unique): " + set);
        System.out.println("Dem so boi cua 7 (khong trung): " + set.size());


    }
}
