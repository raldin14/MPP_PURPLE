package part2.prob10;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Or {

    public static void main(String[] args) {

        /*PART A */

        List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));
        list.stream()
                .map(r -> r.flag)
                .reduce(false, (a, b) -> a || b);

        /*PART B */
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        System.out.println(stringStream.collect(Collectors.joining(", ")));

        /*PART C */
        Stream<Integer> myIntStream = Stream.of(1, 7, 5, 9, 3, 8);

        IntSummaryStatistics stats = myIntStream.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Min: " + stats.getMin() + ", Max: " + stats.getMax());


    }


    public boolean someSimpleIsTrue(List<Simple> list) {
        boolean accum = false;
        for (Simple s : list) {
            accum = accum || s.flag;
        }
        return accum;
    }


}
