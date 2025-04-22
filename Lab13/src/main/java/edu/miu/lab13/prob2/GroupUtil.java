package edu.miu.lab13.prob2;

import java.util.Arrays;
import java.util.List;

public class GroupUtil {
    // Correct implementation using generic method with <T>
    public static <T> Group<T> copy(Group<T> group) {
        List<T> elements = group.getElements();
        // Create a new Group<T> using the same special element and list
        return new Group<>(group.getSpecialElement(), elements);
    }

    // Test using this main method
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);
        Group<Integer> group = new Group<>(0, list);
        System.out.println("Original Group:");
        System.out.println(group);

        Group<Integer> copyGroup = GroupUtil.copy(group);
        System.out.println("Copied Group:");
        System.out.println(copyGroup);
    }
}
