public class PartASol {
    public static void main(String[] args) {
        //a. Is there a compiler error in the following lines of code? If so, where?
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        double dbl = sum(nums);
        // nums.add(3.14);//Compile error
        //Reason
       /* When the extends wildcard is used to define a parametrized type, the type
        cannot be used for adding new elements. Unless is null,*/
    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for(Number num : nums) s += num.doubleValue();
        return s;
    }
}
