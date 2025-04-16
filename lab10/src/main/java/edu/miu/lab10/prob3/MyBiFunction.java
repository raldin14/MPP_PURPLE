package main.java.edu.miu.lab10.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Consider the following lambda expression. Can this expression be correctly typed as a BiFunction?
    (See lesson8.lecture.lambdaexamples.bifunction.) (Hint: Yes it can.) 
 * (x,y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x,y));
            list.add(x * y);
            return list;
            };

    Demonstrate you are right by doing the following: In the main method of a Java class, assign this
    lambda expression to an appropriate BiFunction and call the apply method with arguments (2.0,
    3.0), and print the result to console.
 */
public class MyBiFunction {
    public static void main(String[] args) {
        BiFunction<Double,Double,List<Double>> bF = (x,y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x,y));
            list.add(x * y);
            return list;
            };

            bF.apply(2.0,3.0).forEach(r -> System.out.println("Result : "+r));
    }
}
