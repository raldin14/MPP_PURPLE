package edu.miu.lab10.prob1.a;

import java.util.Comparator;

/**
 * Lab 10 - Part 1a
 * Identifying lambda parameters and free variables.
 */
public class Part1a {

    // i. Runnable lambda with free variables s and t
    public static void runRunnable(int s, int t) {
        Runnable r = () -> {
            int[][] products = new int[s][t];
            for (int i = 0; i < s; i++) {
                for (int j = i + 1; j < t; j++) {
                    products[i][j] = i * j;
                }
            }
            System.out.println("Runnable executed.");
        };
        r.run();
    }

    // ii. Comparator lambda with a free variable: ignoreCase
    public static Comparator<String> getComparator(boolean ignoreCase) {
        return (s, t) -> {
            if (ignoreCase) {
                return s.compareToIgnoreCase(t);
            } else {
                return s.compareTo(t);
            }
        };
    }

    public static void main(String[] args) {
        runRunnable(3, 4); // Example usage of Runnable
        Comparator<String> comp = getComparator(true);
        System.out.println("Comparison result: " + comp.compare("apple", "Banana"));
    }
}
