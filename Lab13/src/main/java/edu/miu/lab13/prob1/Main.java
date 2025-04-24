package edu.miu.lab13.prob1;

public class Main {
    public static void main() {

        // a. 1st fragment
        // List<Integer> ints = new ArrayList<>();
        // ints.add(1);
        // ints.add(2);
        // List<Number> nums = ints;
        // nums.add(3.14);

        /** Answer:
         *Compiler error occurs on the 4th line:
         List<Number> nums = ints;
         * Incompatible types  cannot convert List<Integer> to List<Number>
         * because Java generics are invariant.*/


        // b. Second fragment:
        // List<Integer> ints2 = new ArrayList<>();
        // ints2.add(1);
        // ints2.add(2);
        // List<? extends Number> nums2 = ints;
        // nums2.add(3);

        /** Answer:
         * Compiler error occurs on the 5th line:
         nums2.add(3.14);
         Because we Cannot add to a List<? extends Number> because the exact element type is unknown.
         nums2 could be a List<Integer>, or List<Double>, or List<Float>Java doesn't know! So
         Java blocks adding to ? extends T lists to protect type safety.*/


    }
}
