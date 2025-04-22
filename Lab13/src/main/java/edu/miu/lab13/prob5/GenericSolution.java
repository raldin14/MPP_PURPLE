import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericSolution {
    public static <T extends Comparable<? super T>> T secondSmallest(List<T> list){
        T smallest = list.get(0);
        T secondSmallest = list.get(0);

        for (T num : list) {
            if (num.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num.compareTo(secondSmallest) < 0 && !num.equals(smallest)) {
                secondSmallest = num;
            }
        }

        return secondSmallest;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,0);
        System.out.println(secondSmallest(list));

        List<String> list2 = Arrays.asList("Richar","Logan","Luan","mon","Carmen","Bebo");
        System.out.println(secondSmallest(list2));
    }
}
