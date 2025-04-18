package edu.miu.lab10.prob5;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {
    // A. (Employee e) -> e.getName()
    static Function<Employee, String> getName1 = (Employee e) -> e.getName();

    static Function<Employee, String> getName2 = Employee::getName;
    // Method reference type: Class::instanceMethod

    // B. (Employee e, String s) -> e.setName(s)
    static BiConsumer<Employee, String> setName1 = (e, s) -> e.setName(s);

    static BiConsumer<Employee, String> setName2 = Employee::setName;
    // Method reference type: Class::instanceMethod

    // C. (String s1, String s2) -> s1.compareTo(s2)
    static BiFunction<String, String, Integer> compare1 = (s1, s2) -> s1.compareTo(s2);

    static BiFunction<String, String, Integer> compare2 = String::compareTo;
    // Method reference type: Class::instanceMethod

    // D. (Integer x, Integer y) -> Math.pow(x, y)
    static BiFunction<Integer, Integer, Double> power1 = (x, y) -> Math.pow(x, y);

    static BiFunction<Integer, Integer, Double> power2 = Math::pow;
    // Method reference type: Class::staticMethod

    // E. (Apple a) -> a.getWeight()
    static Function<Apple, Double> weight1 = a -> a.getWeight();

    static Function<Apple, Double> weight2 = Apple::getWeight;
    // Method reference type: Class::instanceMethod

    // F. (String x) -> Integer.parseInt(x)
    static Function<String, Integer> parse1 = x -> Integer.parseInt(x);

    static Function<String, Integer> parse2 = Integer::parseInt;
    // Method reference type: Class::staticMethod

    // G. (Employee e1, Employee e2) -> comp.compare(e1, e2)
    static EmployeeNameComparator comp = new EmployeeNameComparator();

    static Comparator<Employee> comp1 = (e1, e2) -> comp.compare(e1, e2);

    static Comparator<Employee> comp2 = comp::compare;
    // Method reference type: object::instanceMethod

    // 2. Evaluator method
    public static void evaluator() {
        Employee e1 = new Employee("Alice", 5000);
        Employee e2 = new Employee("Bob", 4000);

        System.out.println("A: getName = " + getName2.apply(e1));
        setName2.accept(e1, "Charlie");
        System.out.println("B: setName = " + e1.getName());
        System.out.println("C: compare strings = " + compare2.apply("apple", "banana"));
        System.out.println("D: pow(2, 3) = " + power2.apply(2, 3));
        Apple a = new Apple(1.8);
        System.out.println("E: getWeight = " + weight2.apply(a));
        System.out.println("F: parseInt = " + parse2.apply("12345"));
        System.out.println("G: compare employees = " + comp2.compare(e1, e2));
    }

    public static void main(String[] args) {
        evaluator();
    }
}
