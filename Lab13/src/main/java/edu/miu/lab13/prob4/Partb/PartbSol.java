public class PartbSol {
    public static void main(String[] args) {
        //b. Is there a compiler error in the following lines of code? If so, where?
        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add("two");
        List<? super Integer> ints = objs;
        ints.add(3);
        // double dbl = sum(ints);//Compile error
        /* Reason
         * We can use an extends wildcard when we only get values out of a structure and don’t use a wildcard at all
            when you both get and put values.
         */
    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for(Number num : nums) s += num.doubleValue();
        return s;
    }
}
