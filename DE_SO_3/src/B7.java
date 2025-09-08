import java.util.*;

public class B7 {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) {
            int x = rand.nextInt(100) + 1;
            list.add(x);
        }

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
